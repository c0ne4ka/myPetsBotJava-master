
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.stickers.Sticker;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Bot extends TelegramLongPollingBot {

    boolean cat_dog = false;
    boolean receiveUpdates = false;

    String start_msg = "Hello!\n" +
            "On the vastness of the worldwide network, did you somehow come across this particular bot?\n" +
            "Well then, let's get started!\n" +
            "Send '1' - for adopt cute kitten" + Icon.CAT.get() + "\n" +
            "Send '2' - for adopt adorable puppy" + Icon.DOG.get() + "\n";

    String info_msg = """
            This bot is designed to inform everyone about the problem of stray animals in a playful way.\s
            Also to remind people that any creature needs love and affection.\s
            Do not buy pets from the store - it's better to take them from the nearest animal shelter in your city.

            Kyiv shelter numbers :
            +38 098 177 84 34
            +38 093 193 40 69
            Also you could search in Google and donate to the Animal shelter that you trust.
            """;
    String feed_msg = "Congratulations, you fed your pet!" + Icon.PIZZA.get() + "\n";
    String play_msg = "Congratulations, you played with your pet!" + Icon.BALL.get() + "\n";
    String wash_msg = "Congratulations, you washed your pet!" + Icon.WATTER.get() + "\n";
    String updates_msg = "Do you want to receive Instagram updates from shelter? \n" +
                        "Send '+' or '-' ";
    int hungry = 50;
    int clean = 100;
    int happy = 100;



    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }

    public void sendMsg(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {

                setButton(sendMessage);
                execute(sendMessage);


        }catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }
    public void setButton(SendMessage sendMessage)
    {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();


        keyboardFirstRow.add(new KeyboardButton("Feed"));
        keyboardFirstRow.add(new KeyboardButton("Wash"));
        keyboardFirstRow.add(new KeyboardButton("Play"));
        keyboardSecondRow.add(new KeyboardButton("Health bar"));
        keyboardSecondRow.add(new KeyboardButton("Bot info"));

        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void sendPic(Message message, String stickerId)
    {
        InputFile inputFile = new InputFile();
        SendSticker sendSticker = new SendSticker(message.getChatId().toString(), inputFile.setMedia(stickerId));

        try {
            execute(sendSticker);
        }catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "test_petsbot";
    }

    @Override
    public String getBotToken() {
        return "1917249583:AAGgaYnOSIA8f5xt0m3doPoczH4IE4SzbVM";
    }

    @Override
    public void onUpdateReceived(Update update) {

        //Нужно засунуть в отдельный класс/библиотеку со стикерами
        //КОТЫ

            Sticker BOX = new Sticker();
            BOX.setFileId("CAACAgIAAxkBAANSYLhdcsRyL3qKNvyHvFpIRYt3YgYAArgKAALxIcFJW5HP0kqIib0fBA");
            Sticker FEEDED = new Sticker();
            FEEDED.setFileId("CAACAgIAAxkBAANUYLhdowvbxvnoed9RwpgNmZpZfAADEw8AAj1mwEk-NMr2v9bSRh8E");
            Sticker SED = new Sticker();
            SED.setFileId("CAACAgIAAxkBAANWYLhd3Jk72PUMhPmtdNsqzlRCidMAArgOAAKF4MBJDEgugcixGMMfBA");
            Sticker HUNGRY = new Sticker();
            HUNGRY.setFileId("CAACAgIAAxkBAANZYLheCpP5nqWx0qMTx7nUoZSNr6cAAjoPAAI9JsFJT5GKUQzgXVMfBA");
            Sticker DIRTY = new Sticker();
            DIRTY.setFileId("CAACAgIAAxkBAANeYLheMfMFLkGW5I1wr7gO6zjYe4AAtoNAAIdMcFJO2jGVHVayMfBA");
            Sticker PLAYFULL = new Sticker();
            PLAYFULL.setFileId("CAACAgIAAxkBAANgYLheSLlRVBWd-jXW5TFACV6H6aAAAloSAAIt7cFJXVoBKw5BxcofBA");
            Sticker SLEEP = new Sticker();
            SLEEP.setFileId("CAACAgIAAxkBAANiYLheWSl5LWKXBjUd5gZMGTuPaRYAAh8OAAIEZMBJQ1j1bscJCUEfBA");
            Sticker WASHED = new Sticker();
            WASHED.setFileId("CAACAgIAAxkBAAECYCRguWUX2hkC3uFdcxyijGdLdUL9-gACHg4AAuf-wEnBbEFwKp8qUx8E");

//СОБАКИ

            Sticker BOX1 = new Sticker();
            BOX1.setFileId("CAACAgIAAxkBAAECX-pguWJAOz9nPA2wvfwDAAHdtH_CH5AAApgNAALbNdBJyLPGs3kyNzofBA");
            Sticker FEEDED1 = new Sticker();
            FEEDED1.setFileId("CAACAgIAAxkBAAECYBRguWR3E_ysVCA_6gNMLLb65MuK2AAC8g0AAtG-yUmfgZyYuvi-Sh8E");
            Sticker SED1 = new Sticker();
            SED1.setFileId("CAACAgIAAxkBAAECX9lguV5_WnuJzfE92Qx8EpvRgabwEwACmA8AAsDKyUm6-9Qz-PQ18x8E");
            Sticker HUNGRY1 = new Sticker();
            HUNGRY1.setFileId("CAACAgIAAxkBAAECYBhguWSq0NvcJekiyu4tzvswdnYSUQACLw8AAjYkyEn-tFInuzlvGB8E");
            Sticker DIRTY1 = new Sticker();
            DIRTY1.setFileId("CAACAgIAAxkBAAECYBpguWS_OXvHSQu13imPEU0Yt-g7MQACYQ8AAiGLyEm_vDWqsBVhUR8E");
            Sticker PLAYFULL1 = new Sticker();
            PLAYFULL1.setFileId("CAACAgIAAxkBAAECYBxguWTR0jgBTspF02TelYP6UgqbbgAC8A4AAuKcyUkUAAHogFEkjuQfBA");
            Sticker SLEEP1 = new Sticker();
            SLEEP1.setFileId("CAACAgIAAxkBAAECYB5guWTlUJMscuMPuLi9LdYcW_-z1AACag4AAtWUyUn_GNYtEUoK7h8E");
            Sticker WASHED1 = new Sticker();
            WASHED1.setFileId("CAACAgIAAxkBAAECYCJguWT8Nc22vm0_mJVK6uzdgzFceAACJBEAAhctyUlhU7_15HkwSR8E");


        if (update.hasMessage()) {
            Message message = update.getMessage();

            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                public void run() {
                    hungry -= 5;
                    clean -= 7;
                    happy -= 3;
                }
            }, 0, 60 * 1000);


            timer.schedule(new TimerTask() {
                public void run() {
                    hungry -= 5;
                    clean -= 7;
                    happy -= 3;
                }
            }, 0, 60 * 1000);

           // double life_cycle = 100 * (0.5 * hungry + 0.3 * happy + 0.2 * clean);

            if (hungry <= 5) {
                sendMsg(message, "Please feed your pet");
                if (cat_dog) {
                    sendPic(message, HUNGRY.getFileId());
                }
                if (!cat_dog) {
                    sendPic(message, HUNGRY1.getFileId());
                }
            }

            if (clean <= 5) {
                sendMsg(message, "Please wash your pet");
                if (cat_dog) {
                    sendPic(message, DIRTY.getFileId());
                }
                if (!cat_dog) {
                    sendPic(message, DIRTY1.getFileId());
                }
            }
            if (happy <= 5) {
                sendMsg(message, "Please play with your pet");
                if (cat_dog) {
                    sendPic(message, SED.getFileId());
                }
                if (!cat_dog) {
                    sendPic(message, SED1.getFileId());
                }
            }

            if (message.hasText()) {
                String text = message.getText();

                if (text.equals("/start")) {
                    sendMsg(message, start_msg);


                    sendPic(message, BOX.getFileId());
                    sendPic(message, BOX1.getFileId());


                }
                if (text.equals("1")) {
                    sendMsg(message, """
                            You picked this awesome kitten! Take a good care of it!
                            Congrads!
                            """);
                    cat_dog = true;
                    sendMsg(message, updates_msg);


                }
                if (text.equals("2")) {
                    sendMsg(message, """
                            You picked this awesome doggy! Take a good care of it!
                            Congrads!
                            """);
                    cat_dog = false;
                    sendMsg(message, updates_msg);

                }
                if (text.equals("Bot info")) {
                    sendMsg(message, info_msg);

                }
                if (text.equals("+")) {
                    sendMsg(message, "Ok, we'll send you new shelters' Insta posts \n" +
                            "Also if you want to unfollow updates simply just send '-'");
                    receiveUpdates = true;

                }
                if (text.equals("-")) {
                    sendMsg(message, "Ok, we won't send you new shelters' Insta posts \n" +
                            "Also if you want to follow updates simply just send '+'");
                    receiveUpdates = false;

                }


                if (text.equals("Feed")) {
                    sendMsg(message, feed_msg);
                    if (cat_dog) {
                        sendPic(message, FEEDED.getFileId());
                    }
                    if (!cat_dog) {
                        sendPic(message, FEEDED1.getFileId());
                    }
                    hungry += 20;
                    clean -= 6;
                    happy += 7;

                }
                if (text.equals("Wash")) {
                    sendMsg(message, wash_msg);
                    if (cat_dog) {
                        sendPic(message, WASHED.getFileId());
                    }
                    if (!cat_dog) {
                        sendPic(message, WASHED1.getFileId());
                    }
                    //hungry += 0;
                    clean += 50;
                    happy -= 5;


                }
                if (text.equals("Play")) {
                    sendMsg(message, play_msg);
                    if (cat_dog) {
                        sendPic(message, PLAYFULL.getFileId());
                    }
                    if (!cat_dog) {
                        sendPic(message, PLAYFULL1.getFileId());
                    }
                    hungry -= 3;
                    clean -= 7;
                    happy += 50;

                }
                if (text.equals("Health bar")) {
                    if (hungry >= 100) {
                        hungry = 100;
                    }
                    if (clean >= 100) {
                        clean = 100;
                    }
                    if (happy >= 100) {
                        happy = 100;
                    }
                    sendMsg(message, "Hungry: " + hungry + "/100" + "\n" + "Clean: " + clean + "/100" + "\n" + "Happy: " + happy + "/100");
                    if (cat_dog) {
                        sendPic(message, SLEEP.getFileId());
                    }
                    if (!cat_dog) {
                        sendPic(message, SLEEP1.getFileId());
                    }


                }


            }
            timer.schedule(new TimerTask() {
                public void run() {
                    if (receiveUpdates)
                    sendMsg(message, "spam");
                }
                }, 0, 1000);



        }
        }
    }



