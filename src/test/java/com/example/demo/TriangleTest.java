package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    @DisplayName(value = "输入错误")
    void InputErrorTest(){
        Triangle triangle = new Triangle();
        String type = triangle.Verify(3,3,0);
        assertEquals("输入错误",type);
    }

    @Test
    @DisplayName(value = "非三角形")
    void NotTriangleTest(){
        Triangle triangle = new Triangle();
        String type = triangle.Verify(3,3,7);
        assertEquals("非三角形",type);
    }

    @Test
    @DisplayName(value = "不等边三角形")
    void ScaleneTriangleTest(){
        Triangle triangle = new Triangle();
        String type = triangle.Verify(3,4,6);
        assertEquals("不等边三角形",type);
    }

    @Test
    @DisplayName(value = "等边三角形")
    void EquilateralTriangleTest(){
        Triangle triangle = new Triangle();
        String type = triangle.Verify(3,3,3);
        assertEquals("等边三角形",type);
    }

    @Test
    @DisplayName(value = "等腰三角形")
    void IsoscelesTriangleTest(){
        Triangle triangle = new Triangle();
        String type = triangle.Verify(3,3,4);
        assertEquals("等腰三角形",type);
    }

    @ParameterizedTest
    @DisplayName(value = "一般边界值测试")
    @CsvFileSource(resources = "/一般边界值测试用例.csv",numLinesToSkip = 1)
    void GenBoundaryValueTest(int a,int b,int c,String expectedString){
        Triangle triangle = new Triangle();
        String type = triangle.Verify(a,b,c);
        assertEquals(expectedString,type);
    }

    @ParameterizedTest
    @DisplayName(value = "健壮性边界值测试")
    @CsvFileSource(resources = "/健壮性边界值测试用例.csv",numLinesToSkip = 1)
    void RobBoundaryValueTest(int a,int b,int c,String expectedString){
        Triangle triangle = new Triangle();
        String type = triangle.Verify(a,b,c);
        assertEquals(expectedString,type);
    }
}