package com.example.demo.endpoint;

import com.example.demo.model.PensionAge;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        value = "/savings/pension/calculate-pension-age")
public class CalculatePensionAge {

    @GetMapping("")
    public PensionAge retrievePensionAge(
            @RequestParam(name = "birthDate") final String birthDate) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birtDateAsDate = dateFormat.parse(birthDate);

        if (birtDateAsDate.before(dateFormat.parse("1948-01-01"))) {
            PensionAge pensionAge = new PensionAge();
            pensionAge.setYears(65);
            pensionAge.setMonths(0);
            pensionAge.setDate(
                    new Date(
                            birtDateAsDate.getYear() + 65,
                            birtDateAsDate.getMonth() + 0,
                            birtDateAsDate.getDate()));
            return pensionAge;
        }

        if (birtDateAsDate.before(dateFormat.parse("1950-10-01"))) {
            PensionAge pensionAge = new PensionAge();
            pensionAge.setYears(65);
            pensionAge.setMonths(3);
            pensionAge.setDate(
                    new Date(
                            birtDateAsDate.getYear() + 65,
                            birtDateAsDate.getMonth() + 3,
                            birtDateAsDate.getDate()));
            return pensionAge;
        }

        if (birtDateAsDate.before(dateFormat.parse("1953-01-01"))) {
            PensionAge pensionAge = new PensionAge();
            pensionAge.setYears(66);
            pensionAge.setMonths(0);
            pensionAge.setDate(
                    new Date(
                            birtDateAsDate.getYear() + 66,
                            birtDateAsDate.getMonth() + 0,
                            birtDateAsDate.getDate()));
            return pensionAge;
        }

        if (birtDateAsDate.before(dateFormat.parse("1956-06-01"))) {
            PensionAge pensionAge = new PensionAge();
            pensionAge.setYears(66);
            pensionAge.setMonths(7);
            pensionAge.setDate(
                    new Date(
                            birtDateAsDate.getYear() + 66,
                            birtDateAsDate.getMonth() + 7,
                            birtDateAsDate.getDate()));
            return pensionAge;
        }

        if (birtDateAsDate.before(dateFormat.parse("1961-01-01"))) {
            PensionAge pensionAge = new PensionAge();
            pensionAge.setYears(67);
            pensionAge.setMonths(0);
            pensionAge.setDate(
                    new Date(
                            birtDateAsDate.getYear() + 67,
                            birtDateAsDate.getMonth() + 0,
                            birtDateAsDate.getDate()));
            return pensionAge;
        }


        PensionAge pensionAge = new PensionAge();
        pensionAge.setYears(67);
        pensionAge.setMonths(3);
        pensionAge.setDate(
                new Date(
                        birtDateAsDate.getYear() + 67,
                        birtDateAsDate.getMonth() + 3,
                        birtDateAsDate.getDate()));

        return pensionAge;
    }

}

