package holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.loveplus.R;

/**
 * Created by Administrator on 2016/7/29.
 */
public class ChattingMessageHolder extends RecyclerView.ViewHolder {
    public TextView chattingText;
    public ImageView userImage;
    public ChattingMessageHolder(View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        chattingText = (TextView) itemView.findViewById(R.id.tv_chatting_text);
        userImage = (ImageView) itemView.findViewById(R.id.iv_user_chatting_image);
    }
}
