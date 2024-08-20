package ru.clevertec.plugin.exception

class LastCommitHasTagException extends RuntimeException{
    LastCommitHasTagException() {
        super()
    }

    LastCommitHasTagException(String message) {
        super(message)
    }

    LastCommitHasTagException(String message, Throwable cause) {
        super(message, cause)
    }

    LastCommitHasTagException(Throwable cause) {
        super(cause)
    }

    protected LastCommitHasTagException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace)
    }
}
