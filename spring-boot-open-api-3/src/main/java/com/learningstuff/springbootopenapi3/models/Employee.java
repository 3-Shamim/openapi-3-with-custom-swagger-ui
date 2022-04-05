package com.learningstuff.springbootopenapi3.models;

import lombok.*;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ২৪/২/২২
 * Time: ১০:৫০ AM
 * Email: mdshamim723@gmail.com
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    private String empId;
    private String name;
    private String designation;
    private double salary;

}
