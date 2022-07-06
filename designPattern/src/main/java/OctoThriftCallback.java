/**
 * @author liuLiang
 * @create 2022/7/6 15:13
 * @email kekorand@gmail.com
 * @Description
 */
public interface OctoThriftCallback<T1, T> {
    void addObserver(OctoObserver<T> tOctoObserver);
}
