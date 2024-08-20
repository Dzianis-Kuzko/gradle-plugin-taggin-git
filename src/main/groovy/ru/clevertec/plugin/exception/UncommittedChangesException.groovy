package ru.clevertec.plugin.exception

class UncommittedChangesException extends RuntimeException{
    UncommittedChangesException() {
        super()
    }

    UncommittedChangesException(String message) {
        super(message)
    }

    UncommittedChangesException(String message, Throwable cause) {
        super(message, cause)
    }

    UncommittedChangesException(Throwable cause) {
        super(cause)
    }

    protected UncommittedChangesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace)
    }
}
