package ru.clevertec.plugin.exception

class NotUnderGitControlException extends RuntimeException {
    NotUnderGitControlException() {
    }

    NotUnderGitControlException(String message) {
        super(message)
    }

    NotUnderGitControlException(String message, Throwable cause) {
        super(message, cause)
    }

    NotUnderGitControlException(Throwable cause) {
        super(cause)
    }

    NotUnderGitControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace)
    }
}
