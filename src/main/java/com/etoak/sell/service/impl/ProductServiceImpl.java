package com.etoak.sell.service.impl;

import com.etoak.sell.dataobject.ProductInfo;
import com.etoak.sell.dto.CartDTO;
import com.etoak.sell.enums.ProductStatusEnum;
import com.etoak.sell.enums.ResultEnum;
import com.etoak.sell.exception.ResponseBankException;
import com.etoak.sell.exception.SellException;
import com.etoak.sell.repository.ProductInfoRepository;
import com.etoak.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 15:01 2018/12/3
 * @ Description：
 */
@Service
//@CacheConfig(cacheNames = "product")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    //@Cacheable(key = "123")
    public ProductInfo findOne(String productId) {
        Optional<ProductInfo> optional = repository.findById(productId);
        if(!optional.isPresent()){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            //throw new ResponseBankException();
        }
        return optional.get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    //@CachePut(key = "123")
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            Optional<ProductInfo> optional = repository.findById(cartDTO.getProductId());
            if(!optional.isPresent()){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            ProductInfo productInfo = optional.get();
            Integer result = productInfo.getProductStock() + cartDTO.getPruductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            Optional<ProductInfo> optional = repository.findById(cartDTO.getProductId());
            if(!optional.isPresent()){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            ProductInfo productInfo = optional.get();
            Integer result = productInfo.getProductStock() - cartDTO.getPruductQuantity();
            //超卖    加入redis锁机制
            // TODO
            if (result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        Optional<ProductInfo> optional = repository.findById(productId);
        if(!optional.isPresent()){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
        }
        ProductInfo productInfo = optional.get();
        if (productInfo.getProductStatus() == ProductStatusEnum.UP.getCode()){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        Optional<ProductInfo> optional = repository.findById(productId);
        if(!optional.isPresent()){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
        }
        ProductInfo productInfo = optional.get();
        if (productInfo.getProductStatus() == ProductStatusEnum.DOWN.getCode()){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(productInfo);
    }
}
