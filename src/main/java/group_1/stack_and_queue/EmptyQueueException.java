/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group_1.stack_and_queue;

/**
 *
 * @author oribe
 */
class EmptyQueueException extends Exception {
         public EmptyQueueException() {
        super("Queue is empty");
    }

    public EmptyQueueException(String message) {
        super(message);
    }
}
