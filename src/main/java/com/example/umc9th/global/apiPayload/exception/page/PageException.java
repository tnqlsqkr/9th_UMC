package com.example.umc9th.global.apiPayload.exception.page;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

public class PageException extends GeneralException {
    public PageException(BaseErrorCode code) { super(code); }
}