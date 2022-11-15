package example.lab2.Service;

import example.lab2.Model.AppLogger;
import example.lab2.Repostory.AppLoggerRepostory;
import example.lab2.Service.Interface.AppLoggerInterfice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppLoggerService implements AppLoggerInterfice {

private AppLoggerRepostory appLoggerRepostory;
    @Autowired
    public AppLoggerService(AppLoggerRepostory appLoggerRepostory) {
        this.appLoggerRepostory = appLoggerRepostory;
    }



    @Override
    public void saveApplicationLog(AppLogger appLogger) {
        appLoggerRepostory.save(appLogger);

    }
}
