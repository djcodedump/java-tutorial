package com.deb.ex.apache_camel_examples;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/*
Camel is a black box that receives messages from some endpoint and sends it
to another one.
Within the black box, the messages may be processed or simply redirected.

There may be many senders and many receivers each following its own protocol
such as ftp, http and jms.
The system may require many complex rules such as message from sender A should
be delivered only to B & C.
In situations, you may have to translate the message to another format that
the receiver expects

To meet the above requirements, Enterprise Integration Patterns (EIP) were
documented. Apache Camel provides the implementation of these patterns.
It is a message-oriented middleware that provides rule-based routing and
mediation engine.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new HelloWorldRoute());

        camelContext.start();

    }
}
