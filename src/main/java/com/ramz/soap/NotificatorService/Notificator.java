package com.ramz.soap.NotificatorService;


import com.ramz.soap.Model.User;


import com.ramz.soap.SOAP.Command;
import com.ramz.soap.SOAP.CommandImplService;
import com.ramz.soap.SOAP.RouterServiceImplService;
import com.ramz.soap.SOAP.SetOfUser;
import com.ramz.soap.TrackedChatId.TrackChatId;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Notificator {

    public static void main(String[] args) {
        RouterServiceImplService routerServiceImplService = new RouterServiceImplService();
        Notificator notificator = new Notificator();
        TrackChatId trackChatId = new TrackChatId();
        List<String> trackedList = trackChatId.getTrackedList();
        List<User> allUsers = notificator.allUsers();
        List<String> allChatIds = new ArrayList<>();
        List<User> untrackedUserList;
        List<String> untrackedNames = new ArrayList<>();

        for (User user : allUsers) {
            allChatIds.add(user.getChatId());
        }

        List<String> untrackedUsers;
        untrackedUsers = allChatIds.stream().filter(user2 -> !trackedList.contains(user2)).collect(Collectors.toList());
        List<String> finalUntrackedUsers = untrackedUsers;
        untrackedUserList = allUsers.stream().filter(user3 -> finalUntrackedUsers.contains(user3.getChatId())).collect(Collectors.toList());

        for (User user : untrackedUserList) {
            untrackedNames.add(user.getFullName());
        }

        String message = String.join("\n", untrackedNames);
        routerServiceImplService.getRouterServiceImplPort().sendNotification(message);


        System.out.println(untrackedNames);
    }

    private List<User> allUsers() {
        CommandImplService command = new CommandImplService();
        Command command1 = command.getCommandImplPort();
        SetOfUser users = command1.getAllUsersAndGroups();
        List<com.ramz.soap.SOAP.User> userItems = users.getItem();
        List<User> userList = new ArrayList<>();

        for (com.ramz.soap.SOAP.User user : userItems) {
            userList.add(new User(user.getChatId(), user.getFullName(), user.getGroup()));
        }

        return userList;
    }
}
