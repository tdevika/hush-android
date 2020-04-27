package com.devika.hush.ui.base

class FailedGetDataException : Error() {
    override fun getLocalizedMessage(): String {
        return "Failed get data"
    }
}

class FailedAddDataException : Error() {
    override fun getLocalizedMessage(): String {
        return "Failed add data"
    }
}

class FailedRemoveDataException : Error() {
    override fun getLocalizedMessage(): String {
        return "Failed remove data"
    }
}
