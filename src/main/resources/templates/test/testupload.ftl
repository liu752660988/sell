<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/sell/css/upload.css" rel="stylesheet">
		<title>jQuery测试图片处理算法</title>
	</head>
	<body>
		<div id="content">
			<div class="uploading-imgInput">
				<input readonly="readonly" id="fileText" type="text" class="imgInput-file"/><span id="superImage">图像超像素</span><span id="enhancementImage">图像增强</span>
				<div class="andArea">
					<div class="filePicker">选择</div>
					<input id="fileImage" name="fileImage" type="file" multiple accept='image/jpeg,image/x-png'>
				</div>
			</div>
			<div class="uploading-imgBg1">
				<img id="img_src" class="upload_image" src="/sell/images/imgadd.png"/>
			</div>
			<div><span>图像超像素处理结果</span></div>
            <div class="uploading-imgBg1">
                <img id="super_img_src" class="upload_image" src="/sell/images/imgadd.png"/>
            </div>
            <div><span>图像增强处理结果</span></div>
            <div class="uploading-imgBg1">
                <img id="enhancement_img_src" class="upload_image" src="/sell/images/imgadd.png"/>
            </div>
			
		</div>

		<script src="/sell/js/jquery-1.7.2.min.js"></script>
		
		<script type="text/javascript">
			$(function() {
				
				// 绑定上传按钮
				$("#fileImage").live('change',function(){
					var file = this.files[0]
					$('#fileText').val(file.name + "/" + file.size);
					imgLoad(file);
					console.log(file);
				})
				
				// 图片预览加载
				function imgLoad(file){
					var r = new FileReader();
					r.readAsDataURL(file);
					$(r).load(function(){
						$("#img_src").attr("src",this.result);
					})					
				}
				
				// 绑定图像超像素事件
				$("#superImage").live('click',function(){
					if($("#img_src").attr("src") != "images/imgadd.png"){
						var result = $("#img_src").attr("src");
						var base64 = result.substring(result.indexOf(",") + 1);
						getImageWidth(result, function(width,height){
							console.log("natural===>height:" + height + ",width:" + width);
							$.ajax({
								type:"post",
								url:"/sell/seller/category/parseImage",
								data: {
									base64: base64,
									w: width,
									h: height,
									channel: 3
								},
								dataType: "json",
								success: function(data){
									console.log(data);
                                    $("#super_img_src").attr("src","data:image/jpeg;base64," + data.base64);
								}
							});
						});
					}else{
						alert("请上传图片！");
					}
				})

                // 绑定图像增强事件
                $("#enhancementImage").live('click',function(){
                    if($("#img_src").attr("src") != "images/imgadd.png"){
                        var result = $("#img_src").attr("src");
                        var base64 = result.substring(result.indexOf(",") + 1);
                        getImageWidth(result, function(width,height){
                            console.log("natural===>height:" + height + ",width:" + width);
                            $.ajax({
                                type:"post",
                                url:"/sell/seller/category/enhancementImage",
                                data: {
                                    base64: base64,
                                    w: width,
                                    h: height,
                                    channel: 3,
									type: 0
                                },
                                dataType: "json",
                                success: function(data){
                                    console.log(data);
                                    $("#enhancement_img_src").attr("src","data:image/jpeg;base64," + data.base64);
                                }
                            });
                        });
                    }else{
                        alert("请上传图片！");
                    }
                })
				
				// 获取图片的真实高度
				function getImageWidth(url, callback){
					var img = new Image();
					img.src = url;
					img.onload = function(){
						callback(img.width, img.height);
					}
				}
				
			})
		</script>
	</body>
</html>
