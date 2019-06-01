package org.zhh.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author junhi
 * @Date 2019/5/29 16:45
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class News {

    private Integer id;
    private String title;
    private String author;
    private String content;
    private String type;
    private Integer st;
}
