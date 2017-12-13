这个是Android MVP的demo，以后省的忘记了。


实现起来其实是各种接口，各种回调。 

Model： 数据实体，后台的耗时操作， 比如说网络请求数据等。 
Present： 连接Model跟VIew，也可以做一些耗时的操作。P调用Model的时候，要实现一些回调接口给Model，这样才可以等Model中耗时操作做完，回调到present。
View，刷新界面，相应操作。 当然也要实现一个回调的接口给Present，这样等Model回调了P，p才可以回调View进行界面的刷新
