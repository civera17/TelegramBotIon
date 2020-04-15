import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class IonLohBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String updmess = update.getMessage().getText().toLowerCase();
            SendMessage message = new SendMessage();
            if (updmess.contains("ion")) {
                message.setChatId(update.getMessage().getChatId())
                        .setText("Ion loh");
            }
            if (updmess.contains("mihai")) {
                message.setChatId(update.getMessage().getChatId())
                        .setText("btw ,am auzit ca mihai ghenii, imho.");
            }
                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
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
