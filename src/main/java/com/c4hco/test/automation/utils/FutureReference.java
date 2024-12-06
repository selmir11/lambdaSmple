package com.c4hco.test.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FutureReference {
//    public void createNewDentalGroups2(List<String> grouping) {
//        basicActions.waitForElementToDisappear(spinner, 70);
//        basicActions.waitForElementToBePresent(createNewGroupLink, 70);
//        basicActions.scrollToElement(createNewGroupLink);
//
//        while (dragAMemberHere.size()<grouping.size()) {
//            basicActions.scrollToElement(createNewGroupLink);
//            createNewGroupLink.click();
//        }
//
//        for (int i = grouping.size() - 1; i >= 0; i--) {
//            String[] groupDetail = grouping.get(i).split(":");
//            String[] Names = groupDetail[0].split(",");
//
//            for (String Name : Names) {
//                WebElement dragElement = basicActions.getDriver()
//                        .findElement(By.xpath("//*[@id='SOL-ManageGroupingMembers-MemberDetails']/span[contains(text(), '" + Name + "')]"));
//
//                WebElement dropElement = dragAMemberHere.get(i);
//
//                basicActions.scrollToElement(dragElement);
//                basicActions.scrollToElement(dropElement);
//
//                builder.clickAndHold(dragElement)
//                        .moveToElement(dropElement)
//                        .release(dropElement).build()
//                        .perform();
//
//                basicActions.wait(3000);
//            }
//        }
//    }
}
