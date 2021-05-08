package resources;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Maze {
    private Room startRoom;
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;
    private Room room10;
    private Room cRoom1;
    private Room cRoom2;
    private Room cRoom3;
    private Stage primaryStage;

    private Timeline t1;

    private Room currRoom;
    private int genNum;

    public Maze(Stage primaryStage) {
        int x = (int) (Math.random() * 6);
        this.primaryStage = primaryStage;
        startRoom = new Room("Starting Room");
        currRoom = startRoom;
        room1 = new Room("Room 1");
        room2 = new Room("Room 2");
        room3 = new Room("Room 3");
        room4 = new Room("Room 4");
        room5 = new Room("Room 5");
        room6 = new Room("Room 6");
        room7 = new Room("Room 7");
        room8 = new Room("Room 8");
        room9 = new Room("Room 9");
        room10 = new Room("Final Room");
        cRoom1 = new ChallRoom("Challenge Room 1");
        cRoom2 = new ChallRoom("Challenge Room 2");
        cRoom3 = new ChallRoom("Challenge Room 3");
        startRoom.setUpShop();
        genNum = x;
        if (x == 1) {
            mazeGen1();
        } else if (x == 2) {
            mazeGen2();
        } else if (x == 3) {
            mazeGen3();
        } else if (x == 4) {
            mazeGen4();
        } else {
            mazeGen5();
        }
        currRoom.setIsSafe(true);
        roomLoop();
    }

    private void startRoomGen() {
        //starting room associations
        startRoom.setNRoom(room1);
        room1.setSRoom(startRoom);
        startRoom.setERoom(room2);
        room2.setWRoom(startRoom);
        startRoom.setSRoom(room3);
        room3.setNRoom(startRoom);
        startRoom.setWRoom(room4);
        room4.setERoom(startRoom);
    }
    private void mazeGen1() {
        startRoomGen();
        room2.setERoom(room5);
        room5.setWRoom(room2);
        room5.setERoom(room6);
        room6.setWRoom(room5);
        room6.setNRoom(cRoom1);
        cRoom1.setSRoom(room6);
        room6.setERoom(room7);
        room7.setWRoom(room6);
        room7.setERoom(room8);
        room8.setWRoom(room7);
        room8.setSRoom(cRoom2);
        cRoom2.setNRoom(room8);
        room8.setERoom(room9);
        room9.setWRoom(room8);
        room9.setNRoom(cRoom3);
        cRoom3.setSRoom(room9);
        room9.setERoom(room10);
        room10.setWRoom(room9);
    }

    private void mazeGen2() {
        startRoomGen();
        room3.setSRoom(room5);
        room5.setNRoom(room3);
        room5.setERoom(room6);
        room6.setWRoom(room5);
        room6.setERoom(cRoom1);
        cRoom1.setWRoom(room6);
        room6.setSRoom(room7);
        room7.setNRoom(room6);
        room7.setERoom(room8);
        room8.setWRoom(room7);
        room8.setERoom(cRoom2);
        cRoom2.setWRoom(room8);
        room8.setSRoom(room9);
        room9.setNRoom(room8);
        room9.setWRoom(cRoom3);
        cRoom3.setERoom(room9);
        room9.setSRoom(room10);
        room10.setNRoom(room9);
    }

    private void mazeGen3() {
        startRoomGen();
        room4.setWRoom(room5);
        room5.setERoom(room4);
        room5.setWRoom(room6);
        room6.setERoom(room5);
        room6.setNRoom(cRoom1);
        cRoom1.setSRoom(room6);
        room6.setSRoom(room7);
        room7.setNRoom(room6);
        room7.setSRoom(room8);
        room8.setNRoom(room7);
        room8.setWRoom(cRoom2);
        cRoom2.setERoom(room8);
        room8.setSRoom(room9);
        room9.setNRoom(room8);
        room9.setSRoom(cRoom3);
        cRoom3.setNRoom(room9);
        room9.setERoom(room10);
        room10.setWRoom(room9);
    }

    private void mazeGen4() {
        startRoomGen();
        room1.setNRoom(room5);
        room5.setSRoom(room1);
        room5.setWRoom(room6);
        room6.setERoom(room5);
        room6.setNRoom(room7);
        room6.setWRoom(cRoom1);
        cRoom1.setERoom(room6);
        room7.setSRoom(room6);
        room7.setWRoom(room8);
        room8.setERoom(room7);
        room8.setSRoom(cRoom2);
        cRoom2.setNRoom(room8);
        room8.setWRoom(room9);
        room9.setERoom(room8);
        room9.setWRoom(cRoom3);
        cRoom3.setERoom(room9);
        room9.setNRoom(room10);
        room10.setSRoom(room9);
    }

    private void mazeGen5() {
        startRoomGen();
        room1.setNRoom(room5);
        room5.setSRoom(room1);
        room5.setNRoom(room6);
        room6.setSRoom(room5);
        room6.setWRoom(cRoom1);
        cRoom1.setERoom(room6);
        room6.setNRoom(room7);
        room7.setSRoom(room6);
        room7.setNRoom(room8);
        room8.setSRoom(room7);
        room8.setERoom(cRoom2);
        cRoom2.setWRoom(room8);
        room8.setNRoom(room9);
        room9.setSRoom(room8);
        room9.setWRoom(cRoom3);
        cRoom3.setERoom(room9);
        room9.setNRoom(room10);
        room10.setSRoom(room9);
    }
    public void checkMove() {
        if (currRoom.getnDoor() != null) {
            if (currRoom.getnDoor().isOpen()) {
                if (currRoom.getPlayer().getBoundsInParent()
                        .intersects(currRoom.getnDoor().getBoundsInParent())) {
                    currRoom.passPlayer(currRoom.getnRoom());
                    currRoom.getnDoor();
                    currRoom = currRoom.getnRoom();
                    if (currRoom instanceof ChallRoom) {
                        ((ChallRoom) currRoom).setUp();
                        return;
                    }
                    putMonster();
                }
            }
        }
        if (currRoom.geteDoor() != null) {
            if (currRoom.geteDoor().isOpen()) {
                if (currRoom.getPlayer().getBoundsInParent()
                        .intersects(currRoom.geteDoor().getBoundsInParent())) {
                    currRoom.passPlayer(currRoom.geteRoom());
                    currRoom.geteDoor();
                    currRoom = currRoom.geteRoom();
                    if (currRoom instanceof ChallRoom) {
                        ((ChallRoom) currRoom).setUp();
                        return;
                    }
                    putMonster();
                }
            }
        }
        if (currRoom.getsDoor() != null) {
            if (currRoom.getsDoor().isOpen()) {
                if (currRoom.getPlayer().getBoundsInParent()
                        .intersects(currRoom.getsDoor().getBoundsInParent())) {
                    currRoom.passPlayer(currRoom.getsRoom());
                    currRoom.getsDoor();
                    currRoom = currRoom.getsRoom();
                    if (currRoom instanceof ChallRoom) {
                        ((ChallRoom) currRoom).setUp();
                        return;
                    }
                    putMonster();
                }
            }
        }
        if (currRoom.getwDoor() != null) {
            if (currRoom.getwDoor().isOpen()) {
                if (currRoom.getPlayer().getBoundsInParent()
                        .intersects(currRoom.getwDoor().getBoundsInParent())) {
                    currRoom.passPlayer(currRoom.getwRoom());
                    currRoom.getwDoor();
                    currRoom = currRoom.getwRoom();
                    if (currRoom instanceof ChallRoom) {
                        ((ChallRoom) currRoom).setUp();
                        return;
                    }
                    putMonster();
                }
            }
        }
    }

    private void roomcheck() {
        if (currRoom instanceof ChallRoom) {
            if (((ChallRoom) currRoom).isLocked()) {
                if (!currRoom.getIsSafe()) {
                    ((ChallRoom) currRoom).lockDoors();
                    return;
                }
                ((ChallRoom) currRoom).checkChall();
            }
        }
        if (currRoom.getIsSafe()) {
            if (currRoom.getnRoom() != null) {
                currRoom.getnDoor().setOpen();
            }
            if (currRoom.geteRoom() != null) {
                currRoom.geteDoor().setOpen();
            }
            if (currRoom.getsRoom() != null) {
                currRoom.getsDoor().setOpen();
            }
            if (currRoom.getwRoom() != null) {
                currRoom.getwDoor().setOpen();
            }
        } else {
            if (currRoom.getnRoom() != null) {
                if (currRoom.getnRoom().getIsSafe()) {
                    currRoom.getnDoor().setOpen();
                } else {
                    currRoom.getnDoor().setClosed();
                }
            }
            if (currRoom.geteRoom() != null) {
                if (currRoom.geteRoom().getIsSafe()) {
                    currRoom.geteDoor().setOpen();
                } else {
                    currRoom.geteDoor().setClosed();
                }
            }
            if (currRoom.getsRoom() != null) {
                if (currRoom.getsRoom().getIsSafe()) {
                    currRoom.getsDoor().setOpen();
                } else {
                    currRoom.getsDoor().setClosed();
                }
            }
            if (currRoom.getwRoom() != null) {
                if (currRoom.getwRoom().getIsSafe()) {
                    currRoom.getwDoor().setOpen();
                } else {
                    currRoom.getwDoor().setClosed();
                }
            }


        }
    }

    public void roomLoop() {
        Runnable r = () -> {
            EventHandler<ActionEvent> h1 = event -> {
                checkMove();
                roomcheck();
            };
            KeyFrame k1 = new KeyFrame(Duration.millis(500), h1);
            t1 = new Timeline();
            t1.setCycleCount(Timeline.INDEFINITE);
            t1.getKeyFrames().add(k1);
            t1.play();

        };
        runNow(r);
    }

    public static void runNow(Runnable target) {
        Thread t = new Thread(target, "loop");
        t.setDaemon(true);
        t.start();
    }

    public void switchRooms(Room nextRoom) {
        currRoom.passPlayer(nextRoom);
        currRoom = nextRoom;
        if (nextRoom instanceof ChallRoom) {
            ((ChallRoom) nextRoom).setUp();
            return;
        }
        putMonster();
    }

    public void putMonster() {
        if (!currRoom.getIsSafe()) {
            if (currRoom.getMonster() == null && !currRoom.getRoomText().equals("Final Room")) {
                int x = (int) (Math.random() * 4);
                if (x == 1) {
                    currRoom.setMonster(new MonsterOne(currRoom.getPlayer()));
                } else if (x == 2) {
                    currRoom.setMonster(new MonsterTwo(currRoom.getPlayer()));
                } else {
                    currRoom.setMonster(new MonsterThree(currRoom.getPlayer()));
                }
            } else if (currRoom.getRoomText().equals("Final Room")) {
                currRoom.setMonster(new MonsterFinal(currRoom.getPlayer()));
            }
        }
    }


    public Room getCurrRoom() {
        return this.currRoom;
    }

    public void setCurrRoom(Room currRoom) {
        this.currRoom = currRoom;
    }

    public Room getStartRoom() {
        return startRoom;
    }

    public void setStartRoom(Room startRoom) {
        this.startRoom = startRoom;
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room2 = room2;
    }

    public Room getRoom3() {
        return room3;
    }

    public void setRoom3(Room room3) {
        this.room3 = room3;
    }

    public Room getRoom4() {
        return room4;
    }

    public void setRoom4(Room room4) {
        this.room4 = room4;
    }

    public Room getRoom5() {
        return room5;
    }

    public void setRoom5(Room room5) {
        this.room5 = room5;
    }

    public Room getRoom6() {
        return room6;
    }

    public void setRoom6(Room room6) {
        this.room6 = room6;
    }

    public Room getRoom7() {
        return room7;
    }

    public void setRoom7(Room room7) {
        this.room7 = room7;
    }

    public Room getRoom8() {
        return room8;
    }

    public void setRoom8(Room room8) {
        this.room8 = room8;
    }

    public Room getRoom9() {
        return room9;
    }

    public void setRoom9(Room room9) {
        this.room9 = room9;
    }

    public Room getRoom10() {
        return room10;
    }

    public void setRoom10(Room room10) {
        this.room10 = room10;
    }

    public Room getcRoom1() {
        return cRoom1;
    }

    public void setcRoom1(Room cRoom1) {
        this.cRoom1 = cRoom1;
    }

    public Room getcRoom2() {
        return cRoom2;
    }

    public void setcRoom2(Room cRoom2) {
        this.cRoom2 = cRoom2;
    }

    public Room getcRoom3() {
        return cRoom3;
    }

    public void setcRoom3(Room cRoom3) {
        this.cRoom3 = cRoom3;
    }

    public int getGenNum() {
        return genNum;
    }

    public void setGenNum(int genNum) {
        this.genNum = genNum;
    }
}
