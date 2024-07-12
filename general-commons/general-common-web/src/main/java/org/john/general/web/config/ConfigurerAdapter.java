package org.john.general.web.config;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Johnathon
 */
@EnableWebMvc
@Configuration
public class ConfigurerAdapter implements WebMvcConfigurer {
    private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setDateFormat(new SimpleDateFormat(PATTERN));
        MappingJackson2XmlHttpMessageConverter xmlConverter = new MappingJackson2XmlHttpMessageConverter(xmlMapper);
        xmlConverter.setDefaultCharset(Charset.defaultCharset());
        List<MediaType> xmlMediaTypes = new ArrayList<>();
        xmlMediaTypes.add(MediaType.APPLICATION_XML);
        xmlMediaTypes.add(MediaType.TEXT_XML);
        xmlConverter.setSupportedMediaTypes(xmlMediaTypes);
        converters.add(xmlConverter);

        FastJsonHttpMessageConverter jsonConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig jsonConfig = new FastJsonConfig();
        jsonConfig.setDateFormat(PATTERN);
        jsonConfig.setReaderFeatures(JSONReader.Feature.FieldBased, JSONReader.Feature.SupportArrayToBean);
        jsonConfig.setWriterFeatures(JSONWriter.Feature.WriteMapNullValue, JSONWriter.Feature.PrettyFormat);
        jsonConverter.setFastJsonConfig(jsonConfig);
        jsonConverter.setDefaultCharset(Charset.defaultCharset());
        jsonConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        converters.add(jsonConverter);

        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        stringConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
        converters.add(stringConverter);
    }
}
