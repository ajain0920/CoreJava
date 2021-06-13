<H1>Real Life Example of CompletableFuture</H1>

Now that the functionality of CompletionStage and specifically CompletableFuture is explored, the below example applies them in a practical scenario:

* <p>First fetch a list of Car objects asynchronously by calling the cars() method, which returns a CompletionStage. The cars() method could be consuming a remote REST endpoint behind the scenes.</p>
* <p>We then compose another CompletionStage<List> that takes care of filling the rating of each car, by calling the rating(manufacturerId) method which returns a CompletionStage that asynchronously fetches the car rating (again could be consuming a REST endpoint).</p>
* <p>When all Car objects are filled with their rating, we end up with a List<CompletionStage>, so we call allOf() to get a final stage (stored in variable done) that completes upon completion of all these stages.</p>
* <p>Using whenComplete() on the final stage, we print the Car objects with their rating.</p>
