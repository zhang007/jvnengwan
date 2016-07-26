package com.example.majunpeng.jvnengwan.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zhangfan on 2016/7/26.
 */
public class SDCardUtils {

    //1、判断SD卡是否挂载；
    public static boolean isMounted() {

        // Environment.MEDIA_MOUNTED表示SDCard已经挂载
        // Environment.getExternalStorageState()获得当前的SDCard的挂载状态

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()
        )) {
            return true;
        }
        return false;
    }

    //2、获得SDCard的根目录
    public static String getSDCardBaseDir() {
        if (isMounted()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            return null;
        }
    }

    //3、获得SDCard的大小；
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static long getSDCardSize() {
        if (isMounted()) {
            StatFs statFs = new StatFs(getSDCardBaseDir());
            // StatFs用来计算文件系统存储空间大小的工具类
            // 参数是SDCard的根目录
            StatFs stat = new StatFs(getSDCardBaseDir());

            // 获得SDCard的区域块的数量————
            long count = stat.getBlockCountLong();//Api-i8

            // 获得SDCard的块的大小单位是字节
            long size = stat.getBlockSizeLong();//api--18

            return count * size / 1024 / 1024;

        } else {
            return 0;
        }
    }

    //4、获得SDCard的剩余空间
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static long getSDCardFreeSize() {
        if (isMounted()) {

            StatFs statFs = new StatFs(getSDCardBaseDir());
            long freeBlocksLong = statFs.getFreeBlocksLong();
            long blockSizeLong = statFs.getBlockSizeLong();
            return freeBlocksLong * blockSizeLong / 1024 / 1024;
        } else {
            return 0;
        }
    }

    //5、获得SDCard的可用空间的大小
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static long getSDCardAvailableSize() {
        if (isMounted()) {
            StatFs statFs = new StatFs(getSDCardBaseDir());
            long count = statFs.getAvailableBlocksLong();
            long size = statFs.getBlockSizeLong();
            return size * count / 1024 / 1024;
        } else {
            return 0;
        }
    }

    //6、保存文件到SDCard的公共路径下；
    public static boolean saveDataToSDCardPublicDir(byte[] data, String type,
                                                    String fileName) {
        boolean flag = false;
        if (isMounted()) {
            File file = Environment.getExternalStoragePublicDirectory(type);
            File file1 = new File(file, fileName);
            BufferedOutputStream bos = null;
            FileOutputStream fos = null;
            try {

                fos = new FileOutputStream(file1);
                bos = new BufferedOutputStream(fos);
                bos.write(data);
                bos.flush();
                flag = true;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bos != null) {
                        bos.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return flag;
    }


    //7、保存文件到自定义路径下；
    public static boolean saveDataToSDCardCustomDir(byte[] data, String dir,
                                                    String fileName) {

        boolean flag = false;
        if (isMounted()) {
            File file = new File(getSDCardBaseDir() + File.separator + dir);
            BufferedOutputStream bos = null;
            FileOutputStream fos = null;
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
            }

            try {
                fos = new FileOutputStream(new File(file, fileName));
                bos = new BufferedOutputStream(fos);
                bos.write(data);
                bos.flush();
                flag = true;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bos != null) {
                        bos.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

        return flag;
    }


    //8、保存文件到私有目录下
    public static boolean saveDataToPrivateFilesDir(byte[] data, String type,
                                                    String fileName, Context
                                                            context) {
        boolean flag = false;
        if (isMounted()) {

            BufferedOutputStream bos = null;
            FileOutputStream fos = null;
            File file = context.getExternalFilesDir(type);
            assert file != null;
            if (!file.exists()) {
                file.mkdirs();
            }

            try {
                fos = new FileOutputStream(new File(file, fileName));
                bos = new BufferedOutputStream(fos);
                bos.write(data);
                bos.flush();

                flag = true;

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {

                    if (bos != null) {
                        bos.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


        return flag;
    }

    //9、保存到私有缓存目录下
    public static boolean saveDataToSDCardPrivateCacheDir(byte[] data, String
            fileName, Context context) {
        boolean flag = false;
        if (isMounted()) {
            BufferedOutputStream bos = null;
            FileOutputStream fos = null;
            File file = context.getExternalCacheDir();
            assert file != null;
            if (!file.exists()) {
                file.mkdirs();
            }

            try {
                fos = new FileOutputStream(new File(file, fileName));
                bos = new BufferedOutputStream(fos);
                bos.write(data);
                bos.flush();
                flag = true;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert bos != null;
                    bos.close();
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }

        return flag;
    }


    //10、读取SDCard的文件
    public static byte[] loadFileFromSDCard(String fileDir) {

        byte[] data = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(fileDir)));
            byte[] buffer = new byte[1024 * 8];
            int n = 0;
            while ((n = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, n);
                baos.flush();
            }
            data = baos.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
                assert bis != null;
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return data;
    }

    //SdCard公共文件目录
    public static String getSDCardPublicDir(String type) {
        return Environment.getExternalStoragePublicDirectory(type).toString();
    }

    //私有缓存--对应清楚缓存；
    public static String getSDCardPrivateCacheDir(Context context) {
        return context.getExternalCacheDir().getAbsolutePath();
    }

    //私有文件--存放时间较长的数据，--对应数据的清楚数据
    public static String getSDCardPrivateFilesDir(Context context, String type) {
        return context.getExternalFilesDir(type).getAbsolutePath();
    }

}





