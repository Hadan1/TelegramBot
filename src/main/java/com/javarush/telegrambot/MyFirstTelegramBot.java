package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "Reita142_bot";
    public static final String TOKEN = "1772257325:AAHNDfEewogcxWG_0U8AT0UT5AcD_M5voV4";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        //отобразим сообщение о начале игры

        if (getMessageText().equals("/glory")) {
            sendTextMessageAsync("Сейчас у пользователя очков славы: " + getUserGlory());
        }

        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Взлом холодильника", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of( "Взять сосиску! + 20 славы", "step_2_btn",
                            "взять рыбку! + 20 славы", "step_2_btn",
                            "Скинуть банку с огурцами! + 20 славы", "step_2_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Взлом робота-пылесоса", "step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of( "Отправить пылесос за едой! + 30 славы", "step_4_btn",
                            "Покататься на роботе пылесосе! + 30 славы", "step_4_btn",
                            "Убежать от робота пылесоса! + 30 славы", "step_4_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Включить и одеть камеру GOPRO", "step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            addUserGlory(30);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of( "Бегать по крышам и снимать>! + 40 славы", "step_6_btn",
                            "Нападать на кошек! + 40 славы", "step_6_btn",
                            "Нападать на кошек ! + 40 славы", "step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, Map.of("Взлом компьютера", "step_7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT, Map.of("Выйти во двор похвастаться", "step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            addUserGlory(50);
            sendPhotoMessageAsync("D:\\Java\\TgBot\\src\\main\\resources\\images\\17327000173250.jpg");
            sendTextMessageAsync(FINAL_TEXT);
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}

//        if (getMessageText().equals("/bye")) {
//sendTextMessageAsync("Asta la vista, baby!");
//        }
//
//                if (getMessageText().equals("/start")) {
//sendTextMessageAsync("Ваше любимое животное?",
//                     Map.of("Кот", "Cat", "Собака", "Dog"));
//        }
//
//        if (getCallbackQueryButtonKey().equals("Cat")) {
//sendPhotoMessageAsync("step_4_pic");
//        }
//
//                if (getCallbackQueryButtonKey().equals("Dog")) {
//sendPhotoMessageAsync("step_6_pic");
//        }