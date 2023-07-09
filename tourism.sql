/*
 Navicat Premium Data Transfer

 Source Server         : aaa
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : tourism

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 18/06/2023 14:28:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for destination
-- ----------------------------
DROP TABLE IF EXISTS `destination`;
CREATE TABLE `destination`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of destination
-- ----------------------------
INSERT INTO `destination` VALUES (1, '哈哈哈', '首先要去的就是芙蓉楼，据说此处是唐朝诗人王昌龄游玩会客之所。在清朝时期，又是黔阳本地才子佳人聚集之地据说此处是唐朝诗人王昌龄游玩会客之所。据说此处是唐朝诗人王昌龄游玩会客之所。', '南昌');
INSERT INTO `destination` VALUES (2, '芙蓉楼', '首先要去的就是芙蓉楼，据说此处是唐朝诗人王昌龄游玩会客之所。', '南昌');

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `userid` int(0) NULL DEFAULT NULL,
  `notename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `modifytime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES (1, 2, '芙蓉城记2', '芙蓉古镇是温江依托成都发展的第一门户，又是成都面向川西扩张的第一站，经过河堤整治、屋面造型、城墙围砌等共3期的主体工程实施，一条宽12米、长1200米的仿古一条街终于横空出世，一个崭新的川西“芙蓉古镇”崛起在蓉城近郊，成为成都市民闲暇时近郊游玩的好去处', '江软2', '2023-06-01 00:00:00', '2023-06-18 05:46:34');
INSERT INTO `note` VALUES (2, 1, '芙蓉城记', '芙蓉古镇是温江依托成都发展的第一门户，又是成都面向川西扩张的第一站，经过河堤整治、屋面造型、城墙围砌等共3期的主体工程实施，一条宽12米、长1200米的仿古一条街终于横空出世，一个崭新的川西“芙蓉古镇”崛起在蓉城近郊，成为成都市民闲暇时近郊游玩的好去处', '江软2', '2023-06-13 00:41:29', NULL);
INSERT INTO `note` VALUES (3, 2, '芙蓉城', '芙蓉古镇是温江依托成都发展的第一门户，又是成都面向川西扩张的第一站，经过河堤整治、屋面造型、城墙围砌等共3期的主体工程实施，一条宽12米、长1200米的仿古一条街终于横空出世，一个崭新的川西“芙蓉古镇”崛起在蓉城近郊，成为成都市民闲暇时近郊游玩的好去处', '江软2', '2023-06-13 00:42:49', NULL);
INSERT INTO `note` VALUES (4, 1, '芙蓉城记', '芙蓉古镇是温江依托成都发展的第一门户，又是成都面向川西扩张的第一站，经过河堤整治、屋面造型、城墙围砌等共3期的主体工程实施，一条宽12米、长1200米的仿古一条街终于横空出世，一个崭新的川西“芙蓉古镇”崛起在蓉城近郊，成为成都市民闲暇时近郊游玩的好去处', '江软2', '2023-06-13 14:50:17', NULL);
INSERT INTO `note` VALUES (5, 2, '芙蓉城记', '芙蓉古镇是温江依托成都发展的第一门户，又是成都面向川西扩张的第一站，经过河堤整治、屋面造型、城墙围砌等共3期的主体工程实施，一条宽12米、长1200米的仿古一条街终于横空出世，一个崭新的川西“芙蓉古镇”崛起在蓉城近郊，成为成都市民闲暇时近郊游玩的好去处', '江软2', '2023-06-16 15:48:44', NULL);

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `userid` int(0) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `reviewtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES (1, 1, '长滩岛很小，但是怎么呆都不够，如果只是玩3天就够啦，如果有时间，一躺就是一整天', '2023-06-06 22:35:24');
INSERT INTO `review` VALUES (3, 1, '啊啊啊啊啊啊', '2023-06-10 10:01:45');
INSERT INTO `review` VALUES (5, 1, 'haha', '2023-06-13 10:32:44');
INSERT INTO `review` VALUES (6, 2, '对对对', '2023-06-13 02:35:22');
INSERT INTO `review` VALUES (7, 1, '对对对', '2023-06-13 07:17:16');
INSERT INTO `review` VALUES (33, 2, '你说什么？', '2023-06-17 15:54:52');
INSERT INTO `review` VALUES (34, 2, '你说什么？', '2023-06-17 15:54:59');
INSERT INTO `review` VALUES (35, 2, '旺旺号我还和我呵呵呵', '2023-06-17 15:55:11');
INSERT INTO `review` VALUES (37, 2, '旺旺号我还和我呵呵呵', '2023-06-18 04:00:06');
INSERT INTO `review` VALUES (38, 2, '你说什么？', '2023-06-18 04:00:37');
INSERT INTO `review` VALUES (39, 2, '哈哈哈哈哈', '2023-06-18 06:02:02');
INSERT INTO `review` VALUES (41, 2, '旺旺号我还和我呵呵呵', '2023-06-18 06:14:34');

-- ----------------------------
-- Table structure for review_nd
-- ----------------------------
DROP TABLE IF EXISTS `review_nd`;
CREATE TABLE `review_nd`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `noteid` int(0) NULL DEFAULT NULL,
  `desid` int(0) NULL DEFAULT NULL,
  `reid` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review_nd
-- ----------------------------
INSERT INTO `review_nd` VALUES (1, NULL, 1, 1);
INSERT INTO `review_nd` VALUES (3, 2, NULL, 3);
INSERT INTO `review_nd` VALUES (5, 1, NULL, 5);
INSERT INTO `review_nd` VALUES (6, 4, NULL, 6);
INSERT INTO `review_nd` VALUES (7, 5, NULL, 7);
INSERT INTO `review_nd` VALUES (20, NULL, 1, 33);
INSERT INTO `review_nd` VALUES (21, NULL, 1, 34);
INSERT INTO `review_nd` VALUES (22, 5, NULL, 35);
INSERT INTO `review_nd` VALUES (24, NULL, 1, 37);
INSERT INTO `review_nd` VALUES (25, 3, NULL, 38);
INSERT INTO `review_nd` VALUES (26, NULL, 1, 39);
INSERT INTO `review_nd` VALUES (28, NULL, 1, 41);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '娜娜', 'lMmmFF2v+MHDH0oPpq2E9Q==', '11111', 1222222);
INSERT INTO `user` VALUES (2, '可可', 'lMmmFF2v+MHDH0oPpq2E9Q==', '11111', 1222222);
INSERT INTO `user` VALUES (11, 'hahah', 'lMmmFF2v+MHDH0oPpq2E9Q==', '11111', 1222222);
INSERT INTO `user` VALUES (19, '妹妹', 'lMmmFF2v+MHDH0oPpq2E9Q==', '11111', 1222222);
INSERT INTO `user` VALUES (20, NULL, '2ZD7iG5qVaWZbxkVuhY5ZQ==', NULL, 0);
INSERT INTO `user` VALUES (21, NULL, '+vfQP9sY3C22Rlx+9M4yHw==', NULL, 0);
INSERT INTO `user` VALUES (22, NULL, 'gPrF9EUrQl//x1RP1bX2Bw==', NULL, 0);
INSERT INTO `user` VALUES (23, NULL, 'gPrF9EUrQl//x1RP1bX2Bw==', NULL, 0);
INSERT INTO `user` VALUES (24, NULL, 'gPrF9EUrQl//x1RP1bX2Bw==', NULL, 0);
INSERT INTO `user` VALUES (25, NULL, 'gPrF9EUrQl//x1RP1bX2Bw==', NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
