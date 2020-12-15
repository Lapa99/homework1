 private String nickname;

    public ClientHandler(Server server, Socket socket, String nickname) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        System.out.println("Сообщение от клиента: " + str);
                        if (str.equals("/end")) {
                            break;
                        }
                        server.broadcastMsg(nickname + ": " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }