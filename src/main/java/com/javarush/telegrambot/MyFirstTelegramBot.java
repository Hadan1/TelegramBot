package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "Reita142_bot";
    public static final String TOKEN = "1772257325:AAHNDfEewogcxWG_0U8AT0UT5AcD_M5voV4";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        if (getMessageText().equals("/bye")) {
            sendTextMessageAsync("Asta la vista, baby!");
        }

        if (getMessageText().equals("/start")) {
            sendTextMessageAsync("Ваше любимое животное?",
                    Map.of("Кот", "Cat", "Собака", "Dog"));
        }

        if (getCallbackQueryButtonKey().equals("Cat")) {
            sendPhotoMessageAsync("step_4_pic");
        }

        if (getCallbackQueryButtonKey().equals("Dog")) {
            sendPhotoMessageAsync("step_6_pic");
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}