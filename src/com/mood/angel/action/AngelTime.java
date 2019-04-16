package com.mood.angel.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class AngelTime extends AnAction {

    public static String defaultDateTimeFormatter="yyyy-MM-dd HH:mm:ss";
    @Override
    public void actionPerformed(AnActionEvent e) {

        Project project = e.getData(PlatformDataKeys.PROJECT);
        String title = "当前时间";
        StringBuffer stringBuffer =new StringBuffer();
        stringBuffer.append("获取当天当前时间 :").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(defaultDateTimeFormatter))).append("\n")
                .append("获取当天开始时间 :").append((LocalDateTime.of(LocalDate.now(), LocalTime.MIN)).format(DateTimeFormatter.ofPattern(defaultDateTimeFormatter))).append("\n")
                .append("获取当天结束时间 :").append((LocalDateTime.of(LocalDate.now(), LocalTime.MAX)).format(DateTimeFormatter.ofPattern(defaultDateTimeFormatter))).append("\n")
                .append("获取本月开始时间:").append((LocalDateTime.of(LocalDateTime.now().getYear(),LocalDateTime.now().getMonth(),1,0,0)).format(DateTimeFormatter.ofPattern(defaultDateTimeFormatter))).append("\n")
                .append("获取本月结束时间:").append((LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()),LocalTime.MAX)).format(DateTimeFormatter.ofPattern(defaultDateTimeFormatter))).append("\n");
        Messages.showMessageDialog(project, stringBuffer.toString(), title, Messages.getInformationIcon());
    }
}
