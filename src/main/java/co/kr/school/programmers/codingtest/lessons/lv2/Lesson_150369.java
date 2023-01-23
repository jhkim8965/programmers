package co.kr.school.programmers.codingtest.lessons.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 택배 배달과 수거하기
 * 문제 설명
 * 재할용 택배 상자.png
 *
 * 당신은 일렬로 나열된 n개의 집에 택배를 배달하려 합니다. 배달할 물건은 모두 크기가 같은 재활용 택배 상자에 담아 배달하며, 배달을 다니면서 빈 재활용 택배 상자들을 수거하려 합니다.
 * 배달할 택배들은 모두 재활용 택배 상자에 담겨서 물류창고에 보관되어 있고, i번째 집은 물류창고에서 거리 i만큼 떨어져 있습니다. 또한 i번째 집은 j번째 집과 거리 j - i만큼 떨어져 있습니다. (1 ≤ i ≤ j ≤ n)
 * 트럭에는 재활용 택배 상자를 최대 cap개 실을 수 있습니다. 트럭은 배달할 재활용 택배 상자들을 실어 물류창고에서 출발해 각 집에 배달하면서, 빈 재활용 택배 상자들을 수거해 물류창고에 내립니다. 각 집마다 배달할 재활용 택배 상자의 개수와 수거할 빈 재활용 택배 상자의 개수를 알고 있을 때, 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 구하려 합니다. 각 집에 배달 및 수거할 때, 원하는 개수만큼 택배를 배달 및 수거할 수 있습니다.
 *
 * 다음은 cap=4 일 때, 최소 거리로 이동하면서 5개의 집에 배달 및 수거하는 과정을 나타낸 예시입니다.
 *
 * 배달 및 수거할 재활용 택배 상자 개수
 *
 * 집 #1	집 #2	집 #3	집 #4	집 #5
 * 배달	1개	0개	3개	1개	2개
 * 수거	0개	3개	0개	4개	0개
 * 배달 및 수거 과정
 *
 * 집 #1	집 #2	집 #3	집 #4	집 #5	설명
 * 남은 배달/수거	1/0	0/3	3/0	1/4	2/0	물류창고에서 택배 3개를 트럭에 실어 출발합니다.
 * 남은 배달/수거	1/0	0/3	3/0	0/4	0/0	물류창고에서 5번째 집까지 이동하면서(거리 5) 4번째 집에 택배 1개를 배달하고, 5번째 집에 택배 2개를 배달합니다.
 * 남은 배달/수거	1/0	0/3	3/0	0/0	0/0	5번째 집에서 물류창고까지 이동하면서(거리 5) 4번째 집에서 빈 택배 상자 4개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내리고 택배 4개를 트럭에 싣습니다.
 * 남은 배달/수거	0/0	0/3	0/0	0/0	0/0	물류창고에서 3번째 집까지 이동하면서(거리 3) 1번째 집에 택배 1개를 배달하고, 3번째 집에 택배 3개를 배달합니다.
 * 남은 배달/수거	0/0	0/0	0/0	0/0	0/0	3번째 집에서 물류창고까지 이동하면서(거리 3) 2번째 집에서 빈 택배 상자 3개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내립니다.
 * 16(=5+5+3+3)의 거리를 이동하면서 모든 배달 및 수거를 마쳤습니다. 같은 거리로 모든 배달 및 수거를 마치는 다른 방법이 있지만, 이보다 짧은 거리로 모든 배달 및 수거를 마치는 방법은 없습니다.
 *
 * 트럭에 실을 수 있는 재활용 택배 상자의 최대 개수를 나타내는 정수 cap, 배달할 집의 개수를 나타내는 정수 n, 각 집에 배달할 재활용 택배 상자의 개수를 담은 1차원 정수 배열 deliveries와 각 집에서 수거할 빈 재활용 택배 상자의 개수를 담은 1차원 정수 배열 pickups가 매개변수로 주어집니다. 이때, 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 return 하도록 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 1 ≤ cap ≤ 50
 * 1 ≤ n ≤ 100,000
 * deliveries의 길이 = pickups의 길이 = n
 * deliveries[i]는 i+1번째 집에 배달할 재활용 택배 상자의 개수를 나타냅니다.
 * pickups[i]는 i+1번째 집에서 수거할 빈 재활용 택배 상자의 개수를 나타냅니다.
 * 0 ≤ deliveries의 원소 ≤ 50
 * 0 ≤ pickups의 원소 ≤ 50
 * 트럭의 초기 위치는 물류창고입니다.
 * 입출력 예
 * cap	n	deliveries	pickups	result
 * 4	5	[1, 0, 3, 1, 2]	[0, 3, 0, 4, 0]	16
 * 2	7	[1, 0, 2, 0, 1, 0, 2]	[0, 2, 0, 1, 0, 2, 0]	30
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 문제 예시와 동일합니다.
 * 입출력 예 #2
 *
 * 배달 및 수거할 재활용 택배 상자 개수
 *
 * 집 #1	집 #2	집 #3	집 #4	집 #5	집 #6	집 #7
 * 배달	1개	0개	2개	0개	1개	0개	2개
 * 수거	0개	2개	0개	1개	0개	2개	0개
 * 배달 및 수거 과정
 *
 * 집 #1	집 #2	집 #3	집 #4	집 #5	집 #6	집 #7	설명
 * 남은 배달/수거	1/0	0/2	2/0	0/1	1/0	0/2	2/0	물류창고에서 택배 2개를 트럭에 실어 출발합니다.
 * 남은 배달/수거	1/0	0/2	2/0	0/1	1/0	0/2	0/0	물류창고에서 7번째 집까지 이동하면서(거리 7) 7번째 집에 택배 2개를 배달합니다.
 * 남은 배달/수거	1/0	0/2	2/0	0/1	1/0	0/0	0/0	7번째 집에서 물류창고까지 이동하면서(거리 7) 6번째 집에서 빈 택배 상자 2개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내리고 택배 2개를 트럭에 싣습니다.
 * 남은 배달/수거	1/0	0/2	1/0	0/1	0/0	0/0	0/0	물류창고에서 5번째 집까지 이동하면서(거리 5) 3번째 집에 택배 1개를 배달하고, 5번째 집에 택배 1개를 배달합니다.
 * 남은 배달/수거	1/0	0/1	1/0	0/0	0/0	0/0	0/0	5번째 집에서 물류창고까지 이동하면서(거리 5) 4번째 집에서 빈 택배 상자 1개를 수거하고 2번째 집에서 빈 택배 상자 1개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내리고 택배 2개를 트럭에 싣습니다.
 * 남은 배달/수거	0/0	0/1	0/0	0/0	0/0	0/0	0/0	물류창고에서 3번째 집까지 이동하면서(거리 3) 1번째 집에 택배 1개를 배달하고, 3번째 집에 택배 1개를 배달합니다.
 * 남은 배달/수거	0/0	0/0	0/0	0/0	0/0	0/0	0/0	3번째 집에서 물류창고까지 이동하면서(거리 3) 2번째 집에서 빈 택배 상자 1개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내립니다.
 * 30(=7+7+5+5+3+3)의 거리를 이동하면서 모든 배달 및 수거를 마쳤습니다. 같은 거리로 모든 배달 및 수거를 마치는 다른 방법이 있지만, 이보다 짧은 거리로 모든 배달 및 수거를 마치는 방법은 없습니다.
 * 따라서, 30을 return 하면 됩니다.
 */

public class Lesson_150369 {
    long answer = -1;

    public Lesson_150369(int cap, int n, int[] deliveries, int[] pickups) {
        answer = solution(cap, n, deliveries, pickups);
    }

    public long getAnswer() {
        return answer;
    }

    private long solution(int cap, int n, int[] deliveries, int[] pickups) {

        Navigation navi = new Navigation(n - 1);
        Truck truck = new Truck(cap);
        Queue<DeliveryOrder> deliveryOrders = getNextDeliveryOrders(cap, deliveries, pickups, navi);

        while (deliveryOrders != null) {
            while (!deliveryOrders.isEmpty()) {
                DeliveryOrder deliveryOrder = deliveryOrders.poll();

                try {
                    if (deliveryOrder.getDestination() == 0) {
                        truck.moveTo(deliveryOrder.getDestination())
                                .loadingDeliveryBox(deliveryOrder.getDeliveryBoxes())
                                .unloadingPickupBox(deliveryOrder.getPickupBoxes());
                    } else {
                        truck.moveTo(deliveryOrder.getDestination())
                                .unloadingDeliveryBox(deliveryOrder.getDeliveryBoxes())
                                .loadingPickupBox(deliveryOrder.getPickupBoxes());
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return -1;
                }

                if (deliveryOrder.getDeliveryBoxes() > 0) navi.setLastDeliveryHouse(deliveryOrder.getDestination());
                if (deliveryOrder.getPickupBoxes() > 0) navi.setLastPickupHouse(deliveryOrder.getDestination());
            }

            deliveryOrders = getNextDeliveryOrders(cap, deliveries, pickups, navi);
        }

        return truck.getDistance();
    }

    private Queue<DeliveryOrder> getNextDeliveryOrders(int cap, int[] deliveries, int[] pickups, Navigation navi) {
        Queue<DeliveryOrder> deliveryOrders = new LinkedList<>();

        int furthestDestination = (navi.getLastDeliveryHouse() >= navi.getLastPickupHouse()) ? navi.getLastDeliveryHouse() : navi.getLastPickupHouse();

        if (furthestDestination <= 0) {
            deliveryOrders = null;

        } else {
            int deliveryBoxes = 0;
            int pickupBoxes = 0;

            deliveryOrders.offer(new DeliveryOrder(0, 0, 0));

            for ( ; furthestDestination >= 0; --furthestDestination) {
                int orderMakingType = 0;

                if (deliveryBoxes + deliveries[furthestDestination] <= cap) {
                    deliveryBoxes += deliveries[furthestDestination];
                    orderMakingType += 1;
                }

                if (pickupBoxes + pickups[furthestDestination] <= cap) {
                    pickupBoxes += pickups[furthestDestination];
                    orderMakingType += 2;
                }

                switch (orderMakingType) {
                    case 1:
                        deliveryOrders.offer(new DeliveryOrder(furthestDestination, deliveries[furthestDestination], 0));
                        break;
                    case 2:
                        deliveryOrders.offer(new DeliveryOrder(furthestDestination, 0, pickups[furthestDestination]));
                        break;
                    case 3:
                        deliveryOrders.offer(new DeliveryOrder(furthestDestination, deliveries[furthestDestination], pickups[furthestDestination]));
                        break;
                }

                if (deliveryBoxes >= cap || pickupBoxes >= cap) {
                    deliveryOrders.peek()
                            .setDeliveryBoxes(deliveryBoxes)
                            .setPickupBoxes(pickupBoxes);
                    break;
                }
            }
        }

        return deliveryOrders;
    }

    static class DeliveryOrder {
        private final int destination;
        private int deliveryBoxes;
        private int pickupBoxes;

        public DeliveryOrder(int address, int deliveryBoxes, int pickupBoxes) {
            this.destination = address;
            this.deliveryBoxes = deliveryBoxes;
            this.pickupBoxes = pickupBoxes;
        }

        public int getDestination() {
            return destination;
        }

        public int getDeliveryBoxes() {
            return deliveryBoxes;
        }

        public int getPickupBoxes() {
            return pickupBoxes;
        }

        public DeliveryOrder setDeliveryBoxes(int deliveryBoxes) {
            this.deliveryBoxes = deliveryBoxes;

            return this;
        }

        public DeliveryOrder setPickupBoxes(int pickupBoxes) {
            this.pickupBoxes = pickupBoxes;

            return this;
        }
    }

    static class Navigation {
        private int lastDeliveryHouse = 0;
        private int lastPickupHouse = 0;

        public Navigation(int furthestHouse) {
            this.lastDeliveryHouse = furthestHouse;
            this.lastPickupHouse = furthestHouse;
        }

        public int getLastDeliveryHouse() {
            return lastDeliveryHouse;
        }

        public void setLastDeliveryHouse(int lastDeliHouse) {
            this.lastDeliveryHouse = lastDeliHouse;
        }

        public int getLastPickupHouse() {
            return lastPickupHouse;
        }

        public void setLastPickupHouse(int lastPickHouse) {
            this.lastPickupHouse = lastPickHouse;
        }
    }

    static class Truck {
        private final int cap;
        private int position = 0;
        private int deliveryBoxes = 0;
        private int pickupBoxes = 0;
        private int distance = 0;

        public Truck(int cap) {
            this.cap = cap;
        }

        public Truck loadingDeliveryBox(int deliveryBoxes) throws Exception {
            this.deliveryBoxes += deliveryBoxes;

            if(this.pickupBoxes > cap) throw new Exception("박스의 수는 " + cap + "보다 클 수 없습니다.");

            return this;
        }

        public Truck loadingPickupBox(int pickupBoxes) throws Exception {
            this.pickupBoxes += pickupBoxes;

            if(this.pickupBoxes > cap) throw new Exception("박스의 수는 " + cap + "보다 클 수 없습니다.");

            return this;
        }

        public Truck unloadingDeliveryBox(int deliveryBoxes) throws Exception {
            this.deliveryBoxes += deliveryBoxes;

            if(this.deliveryBoxes < 0) throw new Exception("박스의 수는 0보다 작을 수 없습니다.");

            return this;
        }

        public Truck unloadingPickupBox(int pickupBoxes) throws Exception {
            this.pickupBoxes += pickupBoxes;

            if(this.pickupBoxes < 0) throw new Exception("박스의 수는 0보다 작을 수 없습니다.");

            return this;
        }

        public Truck moveTo(int destination) {
            distance += (destination >= position) ? destination - position : position - destination;
            position = destination;

            return this;
        }

        public int getDistance() {
            return distance;
        }
    }
}