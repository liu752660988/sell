package com.etoak.sell.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * HttpClient4.3工具类
 */
public class HttpClientUtils {
	
	static Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);
	private static RequestConfig requestConfig = null;

	static {
		//设置请求和传输超时时间
		requestConfig = RequestConfig.custom().setSocketTimeout(50000).setConnectTimeout(50000).build();
	}

	/**
	 * post请求传输json参数
	 * @param url url地址
	 * @param jsonParam 参数
	 */
	public static JSONObject httpPost(String url, JSONObject jsonParam) {
		// post请求返回结果
		CloseableHttpClient httpClient = HttpClients.createDefault();
		JSONObject jsonResult = null;
		HttpPost httpPost = new HttpPost(url);
		// 设置请求和传输超时时间
		httpPost.setConfig(requestConfig);
		try {
			if (null != jsonParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				httpPost.setEntity(entity);
			}
			CloseableHttpResponse result = httpClient.execute(httpPost);
			// 请求发送成功，并得到响应
			if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String str = "";
				try {
					// 读取服务器返回过来的json字符串数据
					str = EntityUtils.toString(result.getEntity(), "utf-8");
					// 把json字符串转换成json对象
					jsonResult = JSONObject.parseObject(str);
				} catch (Exception e) {
					LOGGER.error("post请求响应解析失败:" + url, e);
				}
			}
		} catch (IOException e) {
			LOGGER.error("post请求失败:" + url, e);
		} finally {
			httpPost.releaseConnection();
		}
		return jsonResult;
	}

	/**
	 * post请求传输String参数 例如：name=Jack&sex=1&type=2
	 * Content-type:application/x-www-form-urlencoded
	 * @param url 请求地址
	 * @param strParam 请求参数
	 */
	public static JSONObject httpPost(String url, String strParam) {
		// post请求返回结果
		CloseableHttpClient httpClient = HttpClients.createDefault();
		JSONObject jsonResult = null;
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		try {
			if (null != strParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(strParam, "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				httpPost.setEntity(entity);
			}
			CloseableHttpResponse result = httpClient.execute(httpPost);
			// 请求发送成功，并得到响应
			if (result.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String str = "";
				try {
					// 读取服务器返回过来的json字符串数据
					str = EntityUtils.toString(result.getEntity(), "utf-8");
					// 把json字符串转换成json对象
					jsonResult = JSONObject.parseObject(str);
				} catch (Exception e) {
					//throw new ApiException("post请求响应解析失败:" + url);
					LOGGER.error("post请求响应解析失败:" + url, e);
				}
			}
		} catch (IOException e) {
			//throw new ApiException("post请求提交失败:" + url);
			LOGGER.error("post请求失败:" + url, e);
		} finally {
			httpPost.releaseConnection();
		}
		return jsonResult;
	}

	/**
	 * 发送get请求
	 * @param url 路径
	 */
	public static JSONObject httpGet(String url) {
		// get请求返回结果
		JSONObject jsonResult = null;
		CloseableHttpClient client = HttpClients.createDefault();
		// 发送get请求
		HttpGet request = new HttpGet(url);
		request.setConfig(requestConfig);
		try {
			CloseableHttpResponse response = client.execute(request);

			// 请求发送成功，并得到响应
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 读取服务器返回过来的json字符串数据
				HttpEntity entity = response.getEntity();
				String strResult = EntityUtils.toString(entity, "utf-8");
				// 把json字符串转换成json对象
				jsonResult = JSONObject.parseObject(strResult);
			} else {
				//throw new ApiException("get请求提交失败:" + url);
			}
		} catch (IOException e) {
			//throw new ApiException("get请求提交失败:" + url);
		} finally {
			request.releaseConnection();
		}
		return jsonResult;
	}

	/**
	 * 发送Post请求
	 * @param url 路径
	 */
	public static JSONObject httpPost(String url) {
		// get请求返回结果
		JSONObject jsonResult = null;
		CloseableHttpClient client = HttpClients.createDefault();
		// 发送get请求
		HttpPost request = new HttpPost(url);
		request.setConfig(requestConfig);
		try {
			CloseableHttpResponse response = client.execute(request);

			// 请求发送成功，并得到响应
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 读取服务器返回过来的json字符串数据
				HttpEntity entity = response.getEntity();
				String strResult = EntityUtils.toString(entity, "utf-8");
				// 把json字符串转换成json对象
				jsonResult = JSONObject.parseObject(strResult);
			} else {
				//throw new ApiException("get请求提交失败:" + url);
			}
		} catch (IOException e) {
			//throw new ApiException("get请求提交失败:" + url);
		} finally {
			request.releaseConnection();
		}
		return jsonResult;
	}

	/**
	 * 发送 http post 请求，参数以原生字符串进行提交
	 * @param url
	 * @param encode
	 * @return
	 */
	public static String httpPostRaw(String url, String stringJson, Map<String,String> headers, String encode){
		// HttpResponse response = new HttpResponse();
		if(encode == null){
			encode = "utf-8";
		}
		//HttpClients.createDefault()等价于 HttpClientBuilder.create().build();
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		HttpPost httpost = new HttpPost(url);

		//设置header
		httpost.setHeader("Content-type", "application/json");
		if (headers != null && headers.size() > 0) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				httpost.setHeader(entry.getKey(),entry.getValue());
			}
		}
		//组织请求参数
		StringEntity stringEntity = new StringEntity(stringJson, encode);
		httpost.setEntity(stringEntity);
		String content = null;
		CloseableHttpResponse  httpResponse = null;
		try {
			//响应信息
			httpResponse = closeableHttpClient.execute(httpost);
			HttpEntity entity = httpResponse.getEntity();
			content = EntityUtils.toString(entity,"utf-8");

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				httpResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {  //关闭连接、释放资源
			closeableHttpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
}