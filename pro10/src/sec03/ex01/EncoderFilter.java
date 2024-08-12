package sec03.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//webFilter를 통해서 모든 요청이 필터를 거치게 됨
@WebFilter("/")
public class EncoderFilter implements Filter {

    ServletContext context;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("utf-8 인코딩.....");
        context = fConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
        throws ServletException, IOException {
        System.out.println("doFilter 호출");
        req.setCharacterEncoding("utf-8");
        String context = ((HttpServletRequest) req).getContextPath();
        String pathinfo = ((HttpServletRequest) req).getRequestURI();
        String realPath = req.getRealPath(pathinfo);

        String mesg = "Context 정보: " + context
            + "\nURI 정보: " + pathinfo
            + "\n물리적 경로: " + realPath;

        System.out.println(mesg);
        //요청 필터에서 요청 처리 전 시각을 구합니다.
        long begin = System.currentTimeMillis();
        chain.doFilter(req, resp);

        long end = System.currentTimeMillis();
        System.out.println("작업시간: " + (end - begin) + "ms");
    }

    @Override
    public void destroy() {
        System.out.println("디스트로이");
    }

}
