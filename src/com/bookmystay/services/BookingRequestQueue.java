package com.bookmystay.services;

import com.bookmystay.models.Reservation;
import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {
    // Queue data structure to manage booking requests (FIFO)
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        this.requestQueue = new LinkedList<>();
    }

    public void enqueue(Reservation reservation) {
        requestQueue.offer(reservation);
        System.out.println("[ENQUEUE] Added: " + reservation);
    }

    public Reservation dequeue() {
        Reservation res = requestQueue.poll();
        if (res != null) {
            System.out.println("[DEQUEUE] Processing: " + res);
        } else {
            System.out.println("[INFO] Queue is empty.");
        }
        return res;
    }

    public boolean isEmpty() {
        return requestQueue.isEmpty();
    }

    public void displayQueueStatus() {
        System.out.println("--- Queue Status ---");
        System.out.println("Waitlist Size: " + requestQueue.size() + " requests");
    }
}
