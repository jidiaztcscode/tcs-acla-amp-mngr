package com.davivienda.pensionados.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
public class SessionConfig {
    
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        
        // Nombre de la cookie de sesión
        serializer.setCookieName("JSESSIONID");
        
        // SameSite=Lax permite cookies en navegación cross-site
        serializer.setSameSite("Lax");
        
        // HttpOnly para seguridad (no accesible desde JavaScript)
        serializer.setUseHttpOnlyCookie(true);
        
        // Secure=false para desarrollo local (true en producción con HTTPS)
        serializer.setUseSecureCookie(false);
        
        // Path de la cookie
        serializer.setCookiePath("/");
        
        return serializer;
    }
}
