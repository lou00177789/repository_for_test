/**
 * @author liuLiang
 * @create 2022/7/6 15:13
 * @email kekorand@gmail.com
 * @Description
 */
public interface OctoObserver<T> {
    void onSuccess(T t);

    void onFailure(Throwable throwable);
}
