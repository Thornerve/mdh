package com.thor.mdh.web.freemarker;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.StreamUtils;
import org.springframework.web.util.HtmlUtils;

public class StringEscapeHttpMessageConverterr extends StringHttpMessageConverter {
    /** UTF-8 */
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    @Override
    protected void writeInternal(String s, HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException {
        s = HtmlUtils.htmlEscape(s);
        StreamUtils.copy(s, DEFAULT_CHARSET, outputMessage.getBody());
    }
}
