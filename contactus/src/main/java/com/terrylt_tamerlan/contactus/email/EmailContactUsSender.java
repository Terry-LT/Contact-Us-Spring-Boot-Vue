package com.terrylt_tamerlan.contactus.email;

import com.terrylt_tamerlan.contactus.contactus.EmailContactUsRequest;

public interface EmailContactUsSender {
    void send(EmailContactUsRequest emailContactUsRequest);

}
