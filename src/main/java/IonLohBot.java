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
        ArrayList<String> arrayList = new ArrayList<String>();
        Random random = new Random(System.currentTimeMillis());
        if (update.hasMessage() && update.getMessage().hasText()) {
            if (updmess.contains("ion")) {
                arrayList.add("Ion - loh");
                arrayList.add("Ion - bezdari");
                message.setText(arrayList.get(random.nextInt(arrayList.size())));
            }
            if (updmess.contains("mihai")) {
                message.setText("btw ,am auzit ca mihai ghenii, imho.");
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
            if (updmess.contains("mihai") && updmess.contains("loh") || updmess.contains("anime")){
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
        return "1031934675:AAFOS33W0NAG9qMZV5YpRqB8SBg4__w_iDY";
    }
}
