package com.wy.concurrent.Initialize;

/**
 * Created on 2018/7/29.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2018
 * Company:
 *
 * @author wy
 */
public class Tag {
    Tag(int marker){
        System.out.println("Tag("+marker+")");
    }

    Tag(String marker){
        System.out.println("Tag("+marker+")"+"double");
    }
}
