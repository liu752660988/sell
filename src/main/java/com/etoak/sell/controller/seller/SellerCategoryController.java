package com.etoak.sell.controller.seller;

import com.alibaba.fastjson.JSONObject;
import com.etoak.sell.dataobject.BO.ImageParseBO;
import com.etoak.sell.dataobject.ProductCategory;
import com.etoak.sell.enums.ResultEnum;
import com.etoak.sell.form.CategoryForm;
import com.etoak.sell.service.CategoryService;
import com.etoak.sell.util.HttpClientUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 18:32 2018/12/6
 * @ Description：卖家类目controller
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    private static String SUPER_IMAGE_URL = "http://192.168.200.67:8382/";
    private static String ENHANCEMENT_IMAGE_URL = "http://192.168.200.67:8388/";

    @Autowired
    private CategoryService categoryService;

    //类目列表
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map){

        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    //类目展示
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map){
        if (categoryId != null){
            ProductCategory category = categoryService.findOne(categoryId);
            map.put("category", category);
        }
        return new ModelAndView("category/index", map);
    }
    //类目新增或者修改
    @PostMapping("/save")
    public ModelAndView save(@Validated CategoryForm categoryForm,
                             BindingResult bindingResult,
                             Map<String, Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }
        ProductCategory category = new ProductCategory();
        try {
            //如果categoryId是空，说明是新增
            if (!StringUtils.isEmpty(categoryForm.getCategoryId())){
                category = categoryService.findOne(categoryForm.getCategoryId());
            }
            BeanUtils.copyProperties(categoryForm, category);
            categoryService.save(category);
        }catch (Exception e){
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }
        map.put("msg", ResultEnum.CATEGORY_SAVEORUPDATE_SUCCESS.getMessage());
        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success",map);
    }

    //
    @GetMapping("/uploadImage")
    public ModelAndView uploadImage(Map<String, Object> map){

        return new ModelAndView("test/testupload", map);
    }
    // 图像超像素
    @PostMapping("/parseImage")
    @ResponseBody
    public Object parseImage(HttpServletRequest request){

        String base64 = request.getParameter("base64");
        Integer w = Integer.valueOf(request.getParameter("w"));
        Integer h = Integer.valueOf(request.getParameter("h"));
        Integer channel = Integer.valueOf(request.getParameter("channel"));

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("base64", base64);
        paramMap.put("w", w);
        paramMap.put("h", h);
        paramMap.put("channel", channel);

        JSONObject result = HttpClientUtils.httpPost(SUPER_IMAGE_URL + "SuperResolution/", JSONObject.toJSONString(paramMap));

        return result;
    }

    // 图像增强
    @PostMapping("/enhancementImage")
    @ResponseBody
    public Object enhancementImage(HttpServletRequest request){

        String base64 = request.getParameter("base64");
        Integer w = Integer.valueOf(request.getParameter("w"));
        Integer h = Integer.valueOf(request.getParameter("h"));
        Integer channel = Integer.valueOf(request.getParameter("channel"));
        Integer type = Integer.valueOf(request.getParameter("type"));

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("base64", base64);
        paramMap.put("w", w);
        paramMap.put("h", h);
        paramMap.put("channel", channel);
        paramMap.put("type", type);

        JSONObject result = HttpClientUtils.httpPost(ENHANCEMENT_IMAGE_URL + "PictureEnhancement/", JSONObject.toJSONString(paramMap));

        return result;
    }
}
