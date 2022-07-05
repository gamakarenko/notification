package com.ramz.soap.Service;

import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.ramz.soap.Service.TrackedChatIdService")
public class TrackedChatIdServiceImpl implements TrackedChatIdService{

    @Override
    public ArrayList<String> takeTrackedList(ArrayList<String> list){
        System.out.println(list);
        return list;
    }
}
