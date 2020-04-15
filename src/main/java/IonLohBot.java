import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDice;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class IonLohBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        String updmess = update.getMessage().getText().toLowerCase();
        updmess.replaceAll("\\s","");
        SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
        SendDice sendDice = new SendDice().setChatId(update.getMessage().getChatId());
        DeleteMessage deleteMessage = new DeleteMessage().setChatId(update.getMessage().getChatId())
                .setMessageId(update.getMessage().getMessageId());
        if (update.hasMessage() && update.getMessage().hasText()) {
            if (updmess.contains("ion")) {
                message.setText("Ion loh");
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
        }
    }

    public String getBotUsername() {
        return "Bot Ion";
    }

    public String getBotToken() {
        return "1031934675:AAFOS33W0NAG9qMZV5YpRqB8SBg4__w_iDY";
    }
}
