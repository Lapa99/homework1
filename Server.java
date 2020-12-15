    private int counter;
    public Server() {
        counter = 0;
        try {
            ServerSocket serverSocket = new ServerSocket(8289);
            clients = new Vector<>();
            while (true) {
                System.out.println("Ждём подключения клиента");
                Socket socket = serverSocket.accept();
                ClientHandler c = new ClientHandler(this, socket, "Клиент #" + ++counter);
                subscribe(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }