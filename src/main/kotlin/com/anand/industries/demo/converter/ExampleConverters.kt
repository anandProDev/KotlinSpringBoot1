package com.anand.industries.demo.converter

import org.springframework.context.annotation.Bean
import org.springframework.core.convert.ConversionService
import org.springframework.core.convert.converter.Converter
import org.springframework.core.convert.support.DefaultConversionService
import org.springframework.stereotype.Component

@Component
class LongToStringConverter : Converter<Long, String> {
    override fun convert(source: Long): String? {

        return "${source.toString()} converted from Long "
    }
}

//@Component
//class DoubleToStringConverter : Converter<Double, String> {
//    override fun convert(source: Double): String? {
//
//        return "${source.toString()} converted from Double "
//    }
//}

@Component
class IntToStringConverter : Converter<Int, String> {
    override fun convert(source: Int): String? {

        return "${source.toString()} converted from Int "
    }
}

@Component
class EmployeeToStringConverter : Converter<Employee, String> {
    override fun convert(source: Employee): String? {
        return source.toString()
    }
}



@Bean
fun xxx(): ConversionService {
    val service = DefaultConversionService()

    service.addConverter(IntToStringConverter())
    service.addConverter(EmployeeToStringConverter())
    service.addConverter(LongToStringConverter())
    //service.addConverter(DoubleToStringConverter())
    return service
}

@Component
class MyConverterService(private val conversionService: ConversionService){

    fun convertSomething() {

        //println( conversionService.convert(1, String::class.java))
        println(conversionService.convert(1.0, String::class.java))
        //println(conversionService.convert(Employee(), String::class.java))
        //println(conversionService.convert(Student(), Int::class.java))
    }
}

class Employee {
    val id : Int = 0
    val name :String = "Anand"
}

class Student {
    val id : Int = 0
    val name :String = "Anand"
}

