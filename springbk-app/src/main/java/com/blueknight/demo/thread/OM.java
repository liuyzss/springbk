public class MyCounter {
        private int count = 0;

        public void increment() {
                count++;
        }

        public int getCount() {
                return count;
        }
}

public class MyThreadLocal extends ThreadLocal {
}

public class LeakingServlet extends HttpServlet {
        private static MyThreadLocal myThreadLocal = new MyThreadLocal();

        protected void doGet(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {

                MyCounter counter = myThreadLocal.get();
                if (counter == null) {
                        counter = new MyCounter();
                        myThreadLocal.set(counter);
                }

                response.getWriter().println(
                                "The current thread served this servlet " + counter.getCount()
                                                + " times");
                counter.increment();
        }
}