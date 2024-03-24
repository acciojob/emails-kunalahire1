package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    private int inboxCapacity;
    private ArrayList<Mail> inbox;
    private ArrayList<Mail> trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message) {
        if (inbox.size() >= inboxCapacity) {
            moveOldestToTrash();
        }
        inbox.add(new Mail(date, sender, message));
    }

    private void moveOldestToTrash() {
        Mail oldest = inbox.get(0);
        for (Mail mail : inbox) {
            if (mail.date.before(oldest.date)) {
                oldest = mail;
            }
        }
        inbox.remove(oldest);
        trash.add(oldest);
    }

    public void deleteMail(String message) {
        for (Mail mail : inbox) {
            if (mail.message.equals(message)) {
                inbox.remove(mail);
                trash.add(mail);
                break;
            }
        }
    }

    public String findLatestMessage() {
        if (inbox.isEmpty()) {
            return null;
        }
        return inbox.get(inbox.size() - 1).message;
    }

    public String findOldestMessage() {
        if (inbox.isEmpty()) {
            return null;
        }
        return inbox.get(0).message;
    }

    public int findMailsBetweenDates(Date start, Date end) {
        int count = 0;
        for (Mail mail : inbox) {
            if (mail.date.compareTo(start) >= 0 && mail.date.compareTo(end) <= 0) {
                count++;
            }
        }
        return count;
    }

    public int getInboxSize() {
        return inbox.size();
    }

    public int getTrashSize() {
        return trash.size();
    }

    public void emptyTrash() {
        trash.clear();
    }

    public int getInboxCapacity() {
        return inboxCapacity;
    }

    private static class Mail {
        Date date;
        String sender;
        String message;

        Mail(Date date, String sender, String message) {
            this.date = date;
            this.sender = sender;
            this.message = message;
        }
    }
}
