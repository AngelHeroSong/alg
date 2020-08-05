package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server
{
    private int size = 1024;
    private ServerSocketChannel serverSocketChannel;
    private ByteBuffer byteBuffer;
    private Selector selector;
    private int remoteClientNum = 0;

    public Server(int port) {
        try {
            initChannel(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void initChannel(int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(port));

        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        byteBuffer = ByteBuffer.allocate(size);
    }

    public void listen() throws IOException {
        while(true){
             selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel)key.channel();
                    SocketChannel channel = server.accept();
                    registerChannel(selector,channel,SelectionKey.OP_READ);
                    remoteClientNum++;
                    System.out.println("online client num = "+remoteClientNum);
                    write(channel,"hello,client".getBytes());
                }
                if (key.isReadable()){
                    read(key);
                }
                iterator.remove();

            }
        }
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel)key.channel();
        byteBuffer.clear();
        int count = channel.read(byteBuffer);
        if (count>0){
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                System.out.print((char) byteBuffer.get());
            }
            System.out.println();
        }
      //  channel.register(selector,SelectionKey.OP_READ);
        channel.close();


    }

    private void write(SocketChannel channel, byte[] bytes) throws IOException {
        byteBuffer.clear();
        byteBuffer.put(bytes);
        byteBuffer.flip();
        channel.write(byteBuffer);
    }

    private void registerChannel(Selector selector, SocketChannel channel, int opRead) throws IOException {
        if (channel == null){
            return;
        }
        channel.configureBlocking(false);
        channel.register(selector,opRead);
    }

    public static void main(String[] args) {
        Server server = new Server(9999);
        try {
            server.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
