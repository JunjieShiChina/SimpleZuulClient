package me.shijunjie.SimpleZuulClient.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class URLFilter extends ZuulFilter {

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		System.out.println("URLFilter.run");
		ctx.setSendZuulResponse(true);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String method = request.getMethod();
		String requestUrl = request.getRequestURI();

		System.out.println("method:"+method);
		System.out.println("requestUrl:"+requestUrl);

		// 如果为false 跳过run方法，如果为true 进入run方法
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		/**
		 * 在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
	        pre：路由之前
			routing：路由之时
			post： 路由之后
			error：发送错误调用
		 */
		return "pre";
	}

}
