package myArray;


//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// 0 <= nums[i] <= 105
//
// Related Topics 贪心 数组 动态规划
// 👍 1244 👎 0


/**
 * @author caoxiaofeng
 * @date 2021-06-27 14:08
 */
public class CanJump {

    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};

        System.out.println("res: "+ canJump(nums));

        int[] nums2 = {3,2,1,0,4};
        System.out.println("res: "+ canJump(nums2));


        int[] nums3 = {0};
        System.out.println("res: "+ canJump(nums3));

        int[] nums4 = {2,0};
        System.out.println("res: "+ canJump(nums4));


        int[] nums5 = {9997,9997,9996,9995,9994,9993,9992,9991,9990,9989,9988,9987,9986,9985,9984,9983,9982,9981,9980,9979,9978,9977,9976,9975,9974,9973,9972,9971,9970,9969,9968,9967,9966,9965,9964,9963,9962,9961,9960,9959,9958,9957,9956,9955,9954,9953,9952,9951,9950,9949,9948,9947,9946,9945,9944,9943,9942,9941,9940,9939,9938,9937,9936,9935,9934,9933,9932,9931,9930,9929,9928,9927,9926,9925,9924,9923,9922,9921,9920,9919,9918,9917,9916,9915,9914,9913,9912,9911,9910,9909,9908,9907,9906,9905,9904,9903,9902,9901,9900,9899,9898,9897,9896,9895,9894,9893,9892,9891,9890,9889,9888,9887,9886,9885,9884,9883,9882,9881,9880,9879,9878,9877,9876,9875,9874,9873,9872,9871,9870,9869,9868,9867,9866,9865,9864,9863,9862,9861,9860,9859,9858,9857,9856,9855,9854,9853,9852,9851,9850,9849,9848,9847,9846,9845,9844,9843,9842,9841,9840,9839,9838,9837,9836,9835,9834,9833,9832,9831,9830,9829,9828,9827,9826,9825,9824,9823,9822,9821,9820,9819,9818,9817,9816,9815,9814,9813,9812,9811,9810,9809,9808,9807,9806,9805,9804,9803,9802,9801,9800,9799,9798,9797,9796,9795,9794,9793,9792,9791,9790,9789,9788,9787,9786,9785,9784,9783,9782,9781,9780,9779,9778,9777,9776,9775,9774,9773,9772,9771,9770,9769,9768,9767,9766,9765,9764,9763,9762,9761,9760,9759,9758,9757,9756,9755,9754,9753,9752,9751,9750,9749,9748,9747,9746,9745,9744,9743,9742,9741,9740,9739,9738,9737,9736,9735,9734,9733,9732,9731,9730,9729,9728,9727,9726,9725,9724,9723,9722,9721,9720,9719,9718,9717,9716,9715,9714,9713,9712,9711,9710,9709,9708,9707,9706,9705,9704,9703,9702,9701,9700,9699,9698,9697,9696,9695,9694,9693,9692,9691,9690,9689,9688,9687,9686,9685,9684,9683,9682,9681,9680,9679,9678,9677,9676,9675,9674,9673,9672,9671,9670,9669,9668,9667,9666,9665,9664,9663,9662,9661,9660,9659,9658,9657,9656,9655,9654,9653,9652,9651,9650,9649,9648,9647,9646,9645,9644,9643,9642,9641,9640,9639,9638,9637,9636,9635,9634,9633,9632,9631,9630,9629,9628,9627,9626,9625,9624,9623,9622,9621,9620,9619,9618,9617,9616,9615,9614,9613,9612,9611,9610,9609,9608,9607,9606,9605,9604,9603,9602,9601,9600,9599,9598,9597,9596,9595,9594,9593,9592,9591,9590,9589,9588,9587,9586,9585,9584,9583,9582,9581,9580,9579,9578,9577,9576,9575,9574,9573,9572,9571,9570,9569,9568,9567,9566,9565,9564,9563,9562,9561,9560,9559,9558,9557,9556,9555,9554,9553,9552,9551,9550,9549,9548,9547,9546,9545,9544,9543,9542,9541,9540,9539,9538,9537,9536,9535,9534,9533,9532,9531,9530,9529,9528,9527,9526,9525,9524,9523,9522,9521,9520,9519,9518,9517,9516,9515,9514,9513,9512,9511,9510,9509,9508,9507,9506,9505,9504,9503,9502,9501,9500,9499,9498,9497,9496,9495,9494,9493,9492,9491,9490,9489,9488,9487,9486,9485,9484,9483,9482,9481,9480,9479,9478,9477,9476,9475,9474,9473,9472,9471,9470,9469,9468,9467,9466,9465,9464,9463,9462,9461,9460,9459,9458,9457,9456,9455,9454,9453,9452,9451,9450,9449,9448,9447,9446,9445,9444,9443,9442,9441,9440,9439,9438,9437,9436,9435,9434,9433,9432,9431,9430,9429,9428,9427,9426,9425,9424,9423,9422,9421,9420,9419,9418,9417,9416,9415,9414,9413,9412,9411,9410,9409,9408,9407,9406,9405,9404,9403,9402,9401,9400,9399,9398,9397,9396,9395,9394,9393,9392,9391,9390,9389,9388,9387,9386,9385,9384,9383,9382,9381,9380,9379,9378,9377,9376,9375,9374,9373,9372,9371,9370,9369,9368,9367,9366,9365,9364,9363,9362,9361,9360,9359,9358,9357,9356,9355,9354,9353,9352,9351,9350,9349,9348,9347,9346,9345,9344,9343,9342,9341,9340,9339,9338,9337,9336,9335,9334,9333,9332,9331,9330,9329,9328,9327,9326,9325,9324,9323,9322,9321,9320,9319,9318,9317,9316,9315,9314,9313,9312,9311,9310,9309,9308,9307,9306,9305,9304,9303,9302,9301,9300,9299,9298,9297,9296,9295,9294,9293,9292,9291,9290,9289,9288,9287,9286,9285,9284,9283,9282,9281,9280,9279,9278,9277,9276,9275,9274,9273,9272,9271,9270,9269,9268,9267,9266,9265,9264,9263,9262,9261,9260,9259,9258,9257,9256,9255,9254,9253,9252,9251,9250,9249,9248,9247,9246,9245,9244,9243,9242,9241,9240,9239,9238,9237,9236,9235,9234,9233,9232,9231,9230,9229,9228,9227,9226,9225,9224,9223,9222,9221,9220,9219,9218,9217,9216,9215,9214,9213,9212,9211,9210,9209,9208,9207,9206,9205,9204,9203,9202,9201,9200,9199,9198,9197,9196,9195,9194,9193,9192,9191,9190,9189,9188,9187,9186,9185,9184,9183,9182,9181,9180,9179,9178,9177,9176,9175,9174,9173,9172,9171,9170,9169,9168,9167,9166,9165,9164,9163,9162,9161,9160,9159,9158,9157,9156,9155,9154,9153,9152,9151,9150,9149,9148,9147,9146,9145,9144,9143,9142,9141,9140,9139,9138,9137,9136,9135,9134,9133,9132,9131,9130,9129,9128,9127,9126,9125,9124,9123,9122,9121,9120,9119,9118,9117,9116,9115,9114,9113,9112,9111,9110,9109,9108,9107,9106,9105,9104,9103,9102,9101,9100,9099,9098,9097,9096,9095,9094,9093,9092,9091,9090,9089,9088,9087,9086,9085,9084,9083,9082,9081,9080,9079,9078,9077,9076,9075,9074,9073,9072,9071,9070,9069,9068,9067,9066,9065,9064,9063,9062,9061,9060,9059,9058,9057,9056,9055,9054,9053,9052,9051,9050,9049,9048,9047,9046,9045,9044,9043,9042,9041,9040,9039,9038,9037,9036,9035,9034,9033,9032,9031,9030,9029,9028,9027,9026,9025,9024,9023,9022,9021,9020,9019,9018,9017,9016,9015,9014,9013,9012,9011,9010,9009,9008,9007,9006,9005,9004,9003,9002,9001,9000,8999,8998,8997,8996,8995,8994,8993,8992,8991,8990,8989,8988,8987,8986,8985,8984,8983,8982,8981,8980,8979,8978,8977,8976,8975,8974,8973,8972,8971,8970,8969,8968,8967,8966,8965,8964,8963,8962,8961,8960,8959,8958,8957,8956,8955,8954,8953,8952,8951,8950,8949,8948,8947,8946,8945,8944,8943,8942,8941,8940,8939,8938,8937,8936,8935,8934,8933,8932,8931,8930,8929,8928,8927,8926,8925,8924,8923,8922,8921,8920,8919,8918,8917,8916,8915,8914,8913,8912,8911,8910,8909,8908,8907,8906,8905,8904,8903,8902,8901,8900,8899,8898,8897,8896,8895,8894,8893,8892,8891,8890,8889,8888,8887,8886,8885,8884,8883,8882,8881,8880,8879,8878,8877,8876,8875,8874,8873,8872,8871,8870,8869,8868,8867,8866,8865,8864,8863,8862,8861,8860,8859,8858,8857,8856,8855,8854,8853,8852,8851,8850,8849,8848,8847,8846,8845,8844,8843,8842,8841,8840,8839,8838,8837,8836,8835,8834,8833,8832,8831,8830,8829,8828,8827,8826,8825,8824,8823,8822,8821,8820,8819,8818,8817,8816,8815,8814,8813,8812,8811,8810,8809,8808,8807,8806,8805,8804,8803,8802,8801,8800,8799,8798,8797,8796,8795,8794,8793,8792,8791,8790,8789,8788,8787,8786,8785,8784,8783,8782,8781,8780,8779,8778,8777,8776,8775,8774,8773,8772,8771,8770,8769,8768,8767,8766,8765,8764,8763,8762,8761,8760,8759,8758,8757,8756,8755,8754,8753,8752,8751,8750,8749,8748,8747,8746,8745,8744,8743,8742,8741,8740,8739,8738,8737,8736,8735,8734,8733,8732,8731,8730,8729,8728,8727,8726,8725,8724,8723,8722,8721,8720,8719,8718,8717,8716,8715,8714,8713,8712,8711,8710,8709,8708,8707,8706,8705,8704,8703,8702,8701,8700,8699,8698,8697,8696,8695,8694,8693,8692,8691,8690,8689,8688,8687,8686,8685,8684,8683,8682,8681,8680,8679,8678,8677,8676,8675,8674,8673,8672,8671,8670,8669,8668,8667,8666,8665,8664,8663,8662,8661,8660,8659,8658,8657,8656,8655,8654,8653,8652,8651,8650,8649,8648,8647,8646,8645,8644,8643,8642,8641,8640,8639,8638,8637,8636,8635,8634,8633,8632,8631,8630,8629,8628,8627,8626,8625,8624,8623,8622,8621,8620,8619,8618,8617,8616,8615,8614,8613,8612,8611,8610,8609,8608,8607,8606,8605,8604,8603,8602,8601,8600,8599,8598,8597,8596,8595,8594,8593,8592,8591,8590,8589,8588,8587,8586,8585,8584,8583,8582,8581,8580,8579,8578,8577,8576,8575,8574,8573,8572,8571,8570,8569,8568,8567,8566,8565,8564,8563,8562,8561,8560,8559,8558,8557,8556,8555,8554,8553,8552,8551,8550,8549,8548,8547,8546,8545,8544,8543,8542,8541,8540,8539,8538,8537,8536,8535,8534,8533,8532,8531,8530,8529,8528,8527,8526,8525,8524,8523,8522,8521,8520,8519,8518,8517,8516,8515,8514,8513,8512,8511,8510,8509,8508,8507,8506,8505,8504,8503,8502,8501,8500,8499,8498,8497,8496,8495,8494,8493,8492,8491,8490,8489,8488,8487,8486,8485,8484,8483,8482,8481,8480,8479,8478,8477,8476,8475,8474,8473,8472,8471,8470,8469,8468,8467,8466,8465,8464,8463,8462,8461,8460,8459,8458,8457,8456,8455,8454,8453,8452,8451,8450,8449,8448,8447,8446,8445,8444,8443,8442,8441,8440,8439,8438,8437,8436,8435,8434,8433,8432,8431,8430,8429,8428,8427,8426,8425,8424,8423,8422,8421,8420,8419,8418,8417,8416,8415,8414,8413,8412,8411,8410,8409,8408,8407,8406,8405,8404,8403,8402,8401,8400,8399,8398,8397,8396,8395,8394,8393,8392,8391,8390,8389,8388,8387,8386,8385,8384,8383,8382,8381,8380,8379,8378,8377,8376,8375,8374,8373,8372,8371,8370,8369,8368,8367,8366,8365,8364,8363,8362,8361,8360,8359,8358,8357,8356,8355,8354,8353,8352,8351,8350,8349,8348,8347,8346,8345,8344,8343,8342,8341,8340,8339,8338,8337,8336,8335,8334,8333,8332,8331,8330,8329,8328,8327,8326,8325,8324,8323,8322,8321,8320,8319,8318,8317,8316,8315,8314,8313,8312,8311,8310,8309,8308,8307,8306,8305,8304,8303,8302,8301,8300,8299,8298,8297,8296,8295,8294,8293,8292,8291,8290,8289,8288,8287,8286,8285,8284,8283,8282,8281,8280,8279,8278,8277,8276,8275,8274,8273,8272,8271,8270,8269,8268,8267,8266,8265,8264,8263,8262,8261,8260,8259,8258,8257,8256,8255,8254,8253,8252,8251,8250,8249,8248,8247,8246,8245,8244,8243,8242,8241,8240,8239,8238,8237,8236,8235,8234,8233,8232,8231,8230,8229,8228,8227,8226,8225,8224,8223,8222,8221,8220,8219,8218,8217,8216,8215,8214,8213,8212,8211,8210,8209,8208,8207,8206,8205,8204,8203,8202,8201,8200,8199,8198,8197,8196,8195,8194,8193,8192,8191,8190,8189,8188,8187,8186,8185,8184,8183,8182,8181,8180,8179,8178,8177,8176,8175,8174,8173,8172,8171,8170,8169,8168,8167,8166,8165,8164,8163,8162,8161,8160,8159,8158,8157,8156,8155,8154,8153,8152,8151,8150,8149,8148,8147,8146,8145,8144,8143,8142,8141,8140,8139,8138,8137,8136,8135,8134,8133,8132,8131,8130,8129,8128,8127,8126,8125,8124,8123,8122,8121,8120,8119,8118,8117,8116,8115,8114,8113,8112,8111,8110,8109,8108,8107,8106,8105,8104,8103,8102,8101,8100,8099,8098,8097,8096,8095,8094,8093,8092,8091,8090,8089,8088,8087,8086,8085,8084,8083,8082,8081,8080,8079,8078,8077,8076,8075,8074,8073,8072,8071,8070,8069,8068,8067,8066,8065,8064,8063,8062,8061,8060,8059,8058,8057,8056,8055,8054,8053,8052,8051,8050,8049,8048,8047,8046,8045,8044,8043,8042,8041,8040,8039,8038,8037,8036,8035,8034,8033,8032,8031,8030,8029,8028,8027,8026,8025,8024,8023,8022,8021,8020,8019,8018,8017,8016,8015,8014,8013,8012,8011,8010,8009,8008,8007,8};
        long start = System.currentTimeMillis();
        System.out.println("res: "+ canJump(nums5));
        long end = System.currentTimeMillis();

        System.out.println("递归所用时间："+(end - start));


    }


    public static boolean canJump2(int[] nums) {

        int len = nums.length;
        if (len < 2) return true;

        int maxDis = nums[0];

        for (int i = 1; i < len - 1; i++) {
            if (i <= maxDis) {
                maxDis = Math.max(maxDis, nums[i]+i);
            }
        }

        return maxDis >= len - 1;
    }



    public static boolean canJump(int[] nums) {



        return canJumpFrom(nums,0);
    }

    // 递归写法  写法有限时
    public static boolean canJumpFrom(int[] nums,int index){

        int length = nums.length;

        // 递归出口  到达最后
        if (index == nums.length - 1){
            return  true;
        }

        // 递归出口 寸步难行
        if (index >= nums.length || nums[index] == 0 ){
            return false;
        }

        // 递归
        int step = nums[index];

        if (step > (length - 1 - index)){
            return  true;
        }

        step = Math.min(step,length - 1 - index);

        boolean res = false;
        for (int i = step;i > 0;i--){
            res = canJumpFrom(nums,index + i);

            if (res == true){
                break;
            }
        }
        return res;
    }



}
