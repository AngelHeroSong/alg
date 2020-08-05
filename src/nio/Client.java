package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    private int size = 1024;
    private ByteBuffer byteBuffer;
    private SocketChannel socketChannel;

    public void connectServer() throws IOException {
        socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",9999));
        socketChannel.configureBlocking(false);
        byteBuffer = ByteBuffer.allocate(size);
        receive();


    }

    private void receive() throws IOException {
        while(true){
            byteBuffer.clear();
            int count =0;
            //如果没有数据可读取，会一直阻塞
            while((count = socketChannel.read(byteBuffer))>0){
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()){
                    System.out.print((char) byteBuffer.get());
                }
                System.out.println();
                send2Server("say hi".getBytes());
                byteBuffer.clear();

            }
        }
    }

    private void send2Server(byte[] bytes) throws IOException {
        byteBuffer.clear();
        byteBuffer.put(bytes);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        byteBuffer.clear();
    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.connectServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
