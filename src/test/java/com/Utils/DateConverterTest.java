package com.Utils;


import org.junit.Assert;
import org.junit.Test;

import java.time.ZonedDateTime;

public class DateConverterTest {
    String dateString1 = "01-10-2001";

@Test
    public void convertsDateStringToZDT() {
    ZonedDateTime output1 = DateConverter.dateStringToZDT(dateString1);
    Assert.assertEquals(output1.toString(), "2001-10-01T00:00+02:00[Europe/Tallinn]");

    ZonedDateTime output2 = DateConverter.dateStringToZDT("0000");
    Assert.assertNull(output2);

    ZonedDateTime output3 = DateConverter.dateStringToZDT(null);
    Assert.assertNull(output2);
}

@Test
    public void convertsSpecialDateStringToZDT(){
    String dateFormat = "yyyy/MM/dd";
    String dateString = "2001/10/01";
    ZonedDateTime output1 = DateConverter.dateStringToZDTSpecial(dateString, dateFormat);
    Assert.assertEquals(output1.toString(), "2001-10-01T00:00+02:00[Europe/Tallinn]");

    ZonedDateTime output2 = DateConverter.dateStringToZDTSpecial("0000", dateFormat);
    Assert.assertNull(output2);

    ZonedDateTime output3 = DateConverter.dateStringToZDTSpecial(dateString, "0000");
    Assert.assertNull(output3);
}

@Test
    public void getsAgeInYears(){
    ZonedDateTime dateOfBirth = DateConverter.dateStringToZDT(dateString1);
    long output4 = DateConverter.getAgeInYears(dateOfBirth);
    Assert.assertEquals(18, output4);
}
}