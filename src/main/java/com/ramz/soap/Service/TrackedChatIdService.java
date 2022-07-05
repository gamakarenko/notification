package com.ramz.soap.Service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.ArrayList;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface TrackedChatIdService {
    @WebMethod
    ArrayList<String> takeTrackedList(ArrayList<String> list);
}
