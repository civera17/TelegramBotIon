import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDice;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Random;

public class IonLohBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        String updmess = update.getMessage().getText().toLowerCase();
        updmess = updmess.replaceAll("\\s","");
        SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
        SendDice sendDice = new SendDice().setChatId(update.getMessage().getChatId());
        DeleteMessage deleteMessage = new DeleteMessage().setChatId(update.getMessage().getChatId())
                .setMessageId(update.getMessage().getMessageId());
        ArrayList<String> arrayListIon = new ArrayList<String>();
        ArrayList<String> arrayListSergiu = new ArrayList<String>();
        Random random = new Random(System.currentTimeMillis());
        if (update.hasMessage() && update.getMessage().hasText()) {
            if (updmess.contains("ion")) {
                arrayListIon.add("Ion - loh");
                arrayListIon.add("Ion - bezdari");
                arrayListIon.add("Ion - animeshnik");
                arrayListIon.add("Ion - brosateli klinkov");
                arrayListIon.add("Ion - Ariși na mide");
                arrayListIon.add("Ion - Meepo bezdari");
                message.setText(arrayListIon.get(random.nextInt(arrayListIon.size())));
            }
            if (updmess.contains("mihai")) {
                message.setText("btw ,am auzit ca mihai ghenii, imho.");
            }
            if (updmess.contains("sergiu")) {
                arrayListSergiu.add("Sergiu - ruiner");
                arrayListSergiu.add("Sergiu - bezdari");
                arrayListSergiu.add("Sergiu - animeshnik");
                arrayListSergiu.add("Sergiu - tiktoker");
                message.setText(arrayListSergiu.get(random.nextInt(arrayListSergiu.size())));
            }
            if (updmess.contains("rules")){
                message.setText("Equality.");
            }
            if (updmess.contains("5x5")){
                message.setText("Sergiu , sobiraesh ili pustie slova ?");
            }
            if (updmess.contains("dota") || (updmess.contains("doka"))) {
                message.setText("dota - dlia musara");
                message.setText("dota - ne igra");
                message.setText("dota - pamoika");
            }
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            if (updmess.contains("dice") || updmess.contains("ruletca") || updmess.contains("ruletka")
                    || updmess.contains("getrandom") || updmess.contains("shara")) {
                try {
                    execute(sendDice);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (updmess.contains("mihai") && updmess.contains("loh") || updmess.contains("anime")
                    || updmess.contains("anima")){
                try {
                    execute(deleteMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (updmess.contains("mircea") || updmess.contains("petic")) {
                message.setText("Mircea - Bezdari");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getBotUsername() {
        return "Bot Ion";
    }

    public String getBotToken() {
        return "token";
    }
}
